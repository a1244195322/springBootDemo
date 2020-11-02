package com.changfei.demo.modules.user.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author changfei
 * @since 2020-10-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("性别")
    private String sex;

    @TableField("updateDate")
    private LocalDateTime updateDate;


}
