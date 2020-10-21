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
public class AddCourseAndTeacher  implements Serializable {
    private String s_name;
    private int s_id;
    private int sub_id;
    private String sub_miaoshu;
    private String s_yijifenlei;
    private String s_erjifenlei;
    private String s_imageurl;
    private String t_imageurl;
    private Double s_price;
    private String s_type;
    private String s_status;
    private String s_showstatus;

    private Date s_createtime;

    private Date s_updatetime;
    private int deletestatus;
    private int  t_id;
    private String t_name;
}
