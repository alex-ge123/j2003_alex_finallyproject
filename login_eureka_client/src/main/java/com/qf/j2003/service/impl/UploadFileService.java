package com.qf.j2003.service.impl;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
  * Description 文件上传
  * @author sunQuanxi
  * @date 2020/10/16 20:19
  */
@Service
public class UploadFileService {
    @Autowired
    private COSClient cosClient;
    //存储桶名称
    private String bucket = "store-1303871256";
    //存储地址
    private String bucketPath = "https://store-1303871256.cos.ap-chengdu.myqcloud.com/";
    public String fileUpload(MultipartFile file){
        System.out.println("上传处理");
        String path = file.getOriginalFilename();
        String fileName =new SimpleDateFormat("yyyyMMddHH").format(new Date())+path.substring(path.lastIndexOf("."));
        // 指定要上传到的存储桶
        String bucketName = bucket;
       // 指定要上传到 COS 上对象键
        String key = "images/"+fileName;
        try {
            InputStream inputStream = new ByteArrayInputStream(file.getBytes());
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(file.getSize());
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputStream, objectMetadata);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            String filePath = bucketPath + key;
            return filePath;
        } catch (IOException e) {
            return null;
        }
    }
}
