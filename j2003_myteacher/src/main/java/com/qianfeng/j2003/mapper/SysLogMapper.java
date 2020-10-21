package com.qianfeng.j2003.mapper;

import com.qianfeng.j2003.pojo.SysLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jeffrey on 2020/9/1.
 */
@Repository
public interface SysLogMapper {

    public void insertSysLog(SysLog log);
}
