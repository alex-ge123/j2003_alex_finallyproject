package com.qf.j2003.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject implements Serializable {
    private  int sub_id;
    private String sub_miaoshu;
    private int deletestatus;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date startlivetime;

    private String pictureurl;
    private int teacher_id;
    private BigDecimal sub_price;
    private String show_status1;
    private String sub_imgurl;
    private String subtpye;
    private String t_name;
}
