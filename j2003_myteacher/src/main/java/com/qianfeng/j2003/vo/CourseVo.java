package com.qianfeng.j2003.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZAM-PC on 2020/10/16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseVo implements Serializable{
    private Integer s_id;
    private String s_name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date s_liveTime;
}
