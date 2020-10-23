package com.qf.j2003.mapper;

import com.qf.j2003.po.Syslog;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by henry on 2020/10/19.
 */
@Mapper
public interface SyslogMapper {
    public void addSysLog(Syslog syslog);
}
