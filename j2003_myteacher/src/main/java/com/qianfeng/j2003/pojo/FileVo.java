package com.qianfeng.j2003.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by ZAM-PC on 2020/10/20.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileVo implements Serializable{
    private Integer id;
    private String fileUrl;
}
