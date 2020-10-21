package com.qianfeng.j2003.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by ZAM-PC on 2020/10/14.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher implements Serializable{
    private Integer id;
    private String name;
    private String imageurl;
    private String subject;
    private String grade;
    private String info;
}
