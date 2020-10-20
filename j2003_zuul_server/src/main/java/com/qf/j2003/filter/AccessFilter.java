package com.qf.j2003.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.qf.j2003.util.AppConstant;
import com.qf.j2003.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
  * Description 请求拦截
  * @author sunQuanxi
  * @date 2020/10/15 15:56
  */
@Component
public class AccessFilter extends ZuulFilter {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }
    @Override
    public boolean shouldFilter() {
        return true;
    }
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        HttpServletResponse response = requestContext.getResponse();
        String oldRequestUrl = request.getRequestURL().toString();
        System.out.println(oldRequestUrl);
        HttpSession session = request.getSession();
        String uuid = session.getId();
        //判断路径是否拦截
        int i = oldRequestUrl.indexOf("login");
        int j = oldRequestUrl.indexOf("register");
        int k = oldRequestUrl.indexOf("send");
        int l = oldRequestUrl.indexOf("checkToken");
        if (i+j+k+l>0){
            System.out.println("uuid:"+uuid);
            CookieUtil.setCookie(response,"uuid",uuid,60);
            requestContext.setSendZuulResponse(true);
        }else{
            //获取令牌
            String token = CookieUtil.getCookie(request, "token");
            if (StringUtils.isEmpty(token)){
                //请求中获取令牌
                token = request.getParameter("token");
            }
            //令牌为空
            if (StringUtils.isEmpty(token)){
                //重定向到认证中心
                    requestContext.setSendZuulResponse(false);
                    CookieUtil.setCookie(response,"uuid",uuid,60);
                    System.out.println("拦截处理"+uuid);
                System.out.println("响应码设置");
                response.setStatus(403);
            }else{
                //令牌不为空，判断有效性
                System.out.println("令牌"+token);
                MultiValueMap<String,String> map = new LinkedMultiValueMap();
                map.add("token",token);
                Boolean result = restTemplate.postForObject(AppConstant.AUTHEN_CENTER_URL + "lg/checkToken", map, Boolean.class);
                System.out.println("验证结果"+result);
                requestContext.setSendZuulResponse(true);
            }
                //response.sendRedirect("http://localhost:8081/login");
                //requestContext.setResponseStatusCode(403);

        }
        return null;
    }
    /**
     * 跳转页面
     *
     * @param response
     * @param url      需要跳转页面的全路径
     */
//    private void turnPage(HttpServletResponse response, String url) {
//        try {
//            response.setContentType("text/html; charset=utf-8");
//            java.io.PrintWriter out = response.getWriter();
//            out.println("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /> ");
//            out.println("<script>");
//            out.println("window.open ('" + url + "','_top')");
//            out.println("</script>");
//            out.println("</html>");
//            out.flush();
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
