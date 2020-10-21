package com.qianfeng.j2003.service.impl;

import com.qianfeng.j2003.pojo.SysLog;
import com.qianfeng.j2003.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZAM-PC on 2020/10/19.
 */
@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired(required = false)
    private SysLogService sysLogService;
    @Override
    public boolean addSysLog(SysLog log) {
        boolean b = false;
        try{
            b = sysLogService.addSysLog(log);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return b;
    }
}
