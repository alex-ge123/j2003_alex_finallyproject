package com.qianfeng.j2003.service.impl;

import com.qianfeng.j2003.mapper.FilesMapper;
import com.qianfeng.j2003.pojo.FileVo;
import com.qianfeng.j2003.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZAM-PC on 2020/10/20.
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired(required = false)
    private FilesMapper filesMapper;
    @Override
    public boolean addFiles(FileVo f) {
        int i = filesMapper.addFiles(f);
        if(i>-1){
            return true;
        }else{
            return false;
        }

    }
}
