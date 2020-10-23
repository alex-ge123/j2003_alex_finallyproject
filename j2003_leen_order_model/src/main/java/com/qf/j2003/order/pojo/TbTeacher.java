package com.qf.j2003.order.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2020-10-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TbTeacher对象", description="")
public class TbTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一主键")
    @TableId(value = "t_id", type = IdType.ID_WORKER)
    private Integer tId;

    @ApiModelProperty(value = "教师姓名")
    private String tName;

    @ApiModelProperty(value = "教师工号")
    private String tIdcard;

    @ApiModelProperty(value = "头像图片地址")
    private String tImageurl;

    @ApiModelProperty(value = "手机号")
    private String tTel;

    @ApiModelProperty(value = "佣金比例")
    private BigDecimal tMoneyprop;

    @ApiModelProperty(value = "剩余金额")
    private Double tIncomemoney;

    @ApiModelProperty(value = "提现金额")
    private Double tTixainmoney;

    @ApiModelProperty(value = "教师简介")
    private String tBrief;

    @ApiModelProperty(value = "提现时间")
    private Date tTianxiantime;

    @ApiModelProperty(value = "删除状态")
    @Version
    private Integer deletestatus;

    @ApiModelProperty(value = "科目")
    private String tSubject;

    @ApiModelProperty(value = "年级")
    private String tGrade;

    @ApiModelProperty(value = "简介")
    private String tInfo;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
