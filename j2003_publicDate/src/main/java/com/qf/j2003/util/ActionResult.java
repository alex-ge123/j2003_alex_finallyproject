package com.qf.j2003.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActionResult {
    private  Integer StatusCode;
    private String Massage;
    private Object data;
}
