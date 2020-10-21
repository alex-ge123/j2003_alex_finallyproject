package com.qf.j2003.po;

import lombok.Data;

import java.util.Date;

/**
 * Created by henry on 2020/10/19.
 */
@Data
public class Syslog {
    //    ID
    private Integer id;
    //    用户ID
    private Integer userID;
    //    用户操作名
    private String userAction;
    //    用户操作的时间
    private Date createTime;
}