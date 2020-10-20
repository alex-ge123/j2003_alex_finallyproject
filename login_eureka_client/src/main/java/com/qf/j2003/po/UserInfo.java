package com.qf.j2003.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
  * Description TODO
  * @date 2020/10/13 16:32
  */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
    private String tel;
    private String password;
    private Integer radio;
}
