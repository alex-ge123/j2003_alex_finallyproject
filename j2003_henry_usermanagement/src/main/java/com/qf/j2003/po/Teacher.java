package com.qf.j2003.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.Documented;
import java.util.Date;

/**
 * Created by henry on 2020/10/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private Integer tid;  //序号
    private String tidCard;  //编号
    private String timageUrl;  //头像链接
    private String ttel;  //手机号(登录名)
    private String tname; //姓名
    private String tgrade;  //年级
    private String tsubject;  //科目
    private String tinfo; //简介
    private String tmoneyprop; //佣金比例
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date tcreateTime; //创建时间
    private String tincome; //纯收入
    private Double tixainmoney; //已体现余额
    private Integer stuNum; //学生数
    private Integer subNum; //课程数
    private Integer tstatus; //删除状态
    private String password;  //密码
}
