package com.qf.j2003.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by henry on 2020/10/21.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherVo implements Serializable{
    private String username;
    private String tstatus;
    private Date startTime;
    private Date endTime;
}
