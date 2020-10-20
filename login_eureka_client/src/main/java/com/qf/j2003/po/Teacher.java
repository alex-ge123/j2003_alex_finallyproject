package com.qf.j2003.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
  * Description TODO
  * @date 2020/10/13 16:44
  */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {
    private Integer tid;
    private String name;
    private String tel;
    private String password;
}
