package com.qf.j2003.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
  * Description TODO
  * @date 2020/10/12 21:00
  */
@Service
public class SendSmsService {
    public Boolean sendSms(String phone,Map code){
        //连接阿里云
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G14riz1KjBaCmZeWcwx", "N2wzmuY6au59XOg1WBMy6W3C47Rbtm");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        //自定义参数
        request.putQueryParameter("PhoneNumbers",phone);
        request.putQueryParameter("SignName", "优学在线教育");
        //短信模板
        request.putQueryParameter("TemplateCode", "SMS_204287045");
        //验证码
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(code));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return true;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }
}
