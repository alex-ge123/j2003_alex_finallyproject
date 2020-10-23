package com.qianfeng.j2003.util;

import com.google.gson.Gson;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by ZAM-PC on 2020/10/20.
 */
public class QiniuUpload {
    //上传凭证:AccessKey，SecretKey和Bucket
    //上传的AK和SK
    private static String accessKey = VariableName.ACCESS_KEY;
    private static String secretKey = VariableName.SECRET_KEY;
    //上传的空间名
    private static String bucket = VariableName.BUCKET;

    private static Auth auth = Auth.create(accessKey,secretKey);
    private static String upToken = auth.uploadToken(bucket);


    //构造一个带指定Region对象的配置类
    public static Configuration cfg = new Configuration(Region.huanan());
    public static UploadManager uploadManager = new UploadManager(cfg);

    //    上传的方法
    public static String uploadFile(MultipartFile file){
        try {
            byte[] bytes = file.getBytes();//文件流转字节流
            //获取随机文件名
//            String fileName = UUID.randomUUID().toString() + ".png";
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyhhddhhmmss");
            String s = sdf.format(date);
//            System.out.println("date:  " + s);
            String fileName = s+"_"+file.getOriginalFilename();
//            System.out.println("date:  " + fileName);
//            String s = getRandomCharacterAndNumber(10) + ".png";
            Response response = uploadManager.put(bytes, fileName, upToken);
            //解析上传接口
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
//            外部访问的资源地址
            String resUrl = VariableName.DOMAIN_NAME+putRet.key;
            return resUrl;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
