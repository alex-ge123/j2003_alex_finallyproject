package com.qianfeng.j2003.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by ZAM-PC on 2020/10/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysLog {
    private int id;
    private String userName;
    private String userAction;
    private Date createTime;
}
