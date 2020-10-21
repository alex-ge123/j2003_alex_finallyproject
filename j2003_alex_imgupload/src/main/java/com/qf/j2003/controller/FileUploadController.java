package com.qf.j2003.controller;

import com.qf.j2003.util.ActionResult;
import com.qf.j2003.util.QiniuUpload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@Slf4j
public class FileUploadController {
    @RequestMapping(value = "/upload")
    public ActionResult uploadFile(@RequestParam("file") MultipartFile file){
       log.info("上传预览文件");
        ActionResult result = new ActionResult();

        result.setStatusCode(200);
//        上传文件
        String url = QiniuUpload.uploadFile(file);
        result.setData(url);
        return result;
    }
    @RequestMapping(value = "/upload2")
    public ActionResult uploadFile2(@RequestParam("file") MultipartFile file){
        log.info("上传老师头像文件");
        ActionResult result = new ActionResult();
        result.setStatusCode(200);
//        上传文件
        String url = QiniuUpload.uploadFile(file);
        result.setData(url);
        return result;
    }
    @RequestMapping(value = "/test/{id}",method = RequestMethod.GET)
    public String testString (@PathVariable int id){
        log.info("上传测试文件");

        return "ok"+id;
    }
}
