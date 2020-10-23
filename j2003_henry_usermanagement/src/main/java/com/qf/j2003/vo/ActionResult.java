package com.qf.j2003.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by henry on 2020/10/15.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionResult {
    private Integer statusCode;
    private String msg;
    private Object data;
}
