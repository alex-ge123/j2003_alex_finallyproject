package com.qf.j2003.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CourseVo {
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
    private int t_id;
}
