package com.qf.j2003.order.pojo;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderInfo implements Serializable {

    @ApiModelProperty(value = "课程信息")
    private String courseInfo ;
    @ApiModelProperty(value = "教师姓名")
    private String courseTeacher ;
    @ApiModelProperty(value = "课程年级")
    private String courseClass ;
    @ApiModelProperty(value = "支付金额")
    private Double payMoney ;
    @ApiModelProperty(value = "支付时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date payTime ;
    @ApiModelProperty(value = "买家")
    private String payName ;
    @ApiModelProperty(value = "订单编号")
    private String orderNum ;
    @ApiModelProperty(value = "交易状态")
    private String orderStatus ;
    @ApiModelProperty(value = "科目")
    private String course ;

}
