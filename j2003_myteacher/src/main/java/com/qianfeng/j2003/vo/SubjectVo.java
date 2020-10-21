package com.qianfeng.j2003.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZAM-PC on 2020/10/15.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectVo implements Serializable{
    private Integer sub_id;
    private String imgurl;
    private String miaoshu;
    private float price;
    private String status;
    private int time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date startLiveTime;
}
