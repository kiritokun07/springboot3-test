package com.kirito.test.domain;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author kirito
 * @since 2023-08-15 17:42:20
 */
@Getter
@Setter
@TableName("y_user")
@Schema(description = "用户表")
public class YUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "登录名，限20字")
    private String name;

    @Schema(description = "密码，限20字")
    private String pass;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "最近更新时间")
    private LocalDateTime updateTime;
}
