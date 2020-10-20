package com.qf.j2003.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActionResult implements Serializable {
    private  Integer StatusCode;
    private String Massage;
    private Object data;
}
