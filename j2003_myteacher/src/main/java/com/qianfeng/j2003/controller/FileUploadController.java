package com.qianfeng.j2003.controller;

import com.qianfeng.j2003.pojo.FileVo;
import com.qianfeng.j2003.service.FileService;
import com.qianfeng.j2003.util.QiniuUpload;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZAM-PC on 2020/10/20.
 */
@RestController
@Slf4j
public class FileUploadController {
    @Autowired(required = false)
    private FileService fileService;
    @Autowired(required = false)
    private RedisTemplate redisTemplate;
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file){
//        log.info("file: " + file);
//        log.info("fileName: " + file.getOriginalFilename());
//        上传文件
        List<String> arr = new ArrayList<String>();
        String url = QiniuUpload.uploadFile(file);
        FileVo fileVo = new FileVo();
        fileVo.setFileUrl(url);
        boolean b = fileService.addFiles(fileVo);

        if(b){
            System.out.println("写redis......");
            redisTemplate.opsForValue().set("homeworkS",fileVo);
//            String homeworkS =(String) redisTemplate.opsForValue().get("homeworkS");
            Object homeworkS =redisTemplate.opsForValue().get("homeworkS");
            System.out.println("homeworkS:"+homeworkS);
            redisTemplate.opsForList().leftPush("homework",fileVo);
            List homework = redisTemplate.opsForList().range("homework", 0, -1);
            System.out.println("homework:   "+homework);
        }


        return new ResponseEntity(url, HttpStatus.OK);
    }
}
