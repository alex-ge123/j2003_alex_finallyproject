package com.qf.j2003.controller;

import com.qf.j2003.service.impl.UploadFileService;
import com.qf.j2003.util.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
  * Description 文件上传
  * @author sunQuanxi
  * @date 2020/10/16 20:46
  */
@RestController
public class FileController {
    @Autowired
    private UploadFileService uploadFileService;
    @PostMapping("file")
    public ActionResult dealUpload(@RequestParam("file") MultipartFile file){
        System.out.println("文件"+file+",姓名");
        if(file!=null){
            System.out.println("123321");
        String path = uploadFileService.fileUpload(file);
            System.out.println("文件上传路径"+path);
        if (path!=null){
            return new ActionResult(200,"上传成功",null );
        }
        }
        return new ActionResult(404,"上传失败",null );
    }
}
