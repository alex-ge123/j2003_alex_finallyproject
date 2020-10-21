package com.qf.j2003.order.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryWrapper {

    private Integer page ;
    private Integer size ;
    @ApiModelProperty(value = "课程名称")
    private String courseInfo;
    @ApiModelProperty(value = "买家姓名")
    private String payName;
    @ApiModelProperty(value = "订单编号")
    private String orderNum;
    @ApiModelProperty(value = "课程状态")
    private String orderStatus;

}
