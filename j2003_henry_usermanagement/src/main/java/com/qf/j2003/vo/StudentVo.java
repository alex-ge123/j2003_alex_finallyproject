package com.qf.j2003.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by henry on 2020/10/20.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVo implements Serializable{
    private String username;
    private Date startTime;
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date endTime;
}
