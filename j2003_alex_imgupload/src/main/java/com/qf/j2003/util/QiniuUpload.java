package com.qf.j2003.util;



import com.google.gson.Gson;
import com.qf.j2003.config.VariableName;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;

import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Random;


public class QiniuUpload {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    private static String ACCESS_KEY = VariableName.accessKey; //这两个登录七牛 账号里面可以找到
    private static String SECRET_KEY = VariableName.secretKey;

    //要上传的空间
    private static String bucketname = VariableName.bucket; //对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置公开）

    //密钥配置
    private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    private static Configuration cfg = new Configuration(Region.huanan());
    //创建上传对象

    private static UploadManager uploadManager = new UploadManager(cfg);

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public static String getUpToken(){
        return auth.uploadToken(bucketname);
    }
    //    上传通用实现
    public static String uploadFile(MultipartFile file){
        try {
////            获取上传文件流
//            InputStream inputStream = file.getInputStream();
////            定义内存流对象
//            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
////            定义缓冲区
//            byte[] buff = new byte[512];
//            int len = 0;
////            将上传文件流转成内存流
//            while((len = inputStream.read(buff,0,128))>0){
//                swapStream.write(buff,0,len);
//            }
////            内存流转字节数组
//            byte[] uploadBytes = swapStream.toByteArray();
            byte[] uploadBytes = file.getBytes();//文件流转字节流
//            获取随机文件名
            String fileName = getRandomCharacterAndNumber(10)+".jpg";
            Response response = uploadManager.put(uploadBytes, fileName, getUpToken());
//            解析上传结果
            DefaultPutRet putPet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
//            外部访问的资源地址
            String resUrl = VariableName.domain+putPet.key;
            return resUrl;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    //随机生成字符串
    public static String getRandomCharacterAndNumber(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 字符串
            if ("char".equalsIgnoreCase(charOrNum))
            {
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
                val += (char) (choice + random.nextInt(26));
                // int choice = 97; // 指定字符串为小写字母
            } else if ("num".equalsIgnoreCase(charOrNum)) // 数字
            {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

}
