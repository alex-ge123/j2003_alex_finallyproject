package com.qf.j2003.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
 s_id
sub_id        int(11)
s_name        varchar(20)
s_yijifenlei  varchar(20)
s_erjifenlei  varchar(20)
s_imageurl    varchar(200)
s_price       double
s_type        varchar(10)
s_status      varchar(10)
s_showstatus  varchar(10)
s_createtime  date
s_updatetime  date
deletestatus  int(11)
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private  int s_id;
    private int sub_id;
    private String s_name;
    private String s_yijifenlei;
    private String s_erjifenlei;
    private String s_imageurl;
    private Double s_price;
    private String s_type;
    private String s_status;
    private String s_showstatus;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date s_createtime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date s_updatetime;
    private int deletestatus;
    private Object Subject;

}
