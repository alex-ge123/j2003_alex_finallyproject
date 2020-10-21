package com.qf.j2003.service.impl;

import com.qf.j2003.mapper.SyslogMapper;
import com.qf.j2003.po.Syslog;
import com.qf.j2003.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by henry on 2020/10/19.
 */
@Service
public class SyslogServiceImpl implements SyslogService{
    @Autowired(required = false)
    private SyslogMapper syslogMapper;
    @Override
    public void insertSyslog(Syslog syslog) {
        syslogMapper.addSysLog(syslog);
    }
}
