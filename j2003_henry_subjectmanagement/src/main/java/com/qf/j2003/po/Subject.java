package com.qf.j2003.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by henry on 2020/10/16.
 * 课程信息实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    private Integer subId;  //课程id
    private String subDesc;     //课程名字(描述)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date liveTime;      //开课时间
    private String pictureUrl;      //课程封面图片地址
    private String subType;  //课程类型(语文,,数学...)
}
