package com.qf.j2003.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseManagement implements Serializable {
   private int s_id;
   private String s_name;
   private String s_yijifenlei;
   private String s_erjifenlei;
   private String  s_imageurl;
   private String t_imageurl;
   private String t_name;
   private String  nianji;
   private Double s_price;
   private String s_type;
   private String s_showstatus;
   private String s_status;
   private  String sub_miaoshu;
   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
   private Date s_createtime;
   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
   private Date s_updatetime;
}
