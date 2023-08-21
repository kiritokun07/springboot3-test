//package com.kirito.test.domain;
//
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.annotation.TableId;
//import com.baomidou.mybatisplus.annotation.TableName;
//import lombok.Data;
//
//import java.io.Serializable;
//import java.util.Date;
//
///**
// * 内容表
// *
// * @author 公众号:知了一笑
// * @since 2023-07-28 13:27
// */
//@Data
//@TableName("tb_contents")
//public class Contents implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//    /**
//     * 主键
//     */
//    @TableId(value = "id", type = IdType.AUTO)
//    private Integer id;
//
//    /**
//     * 标题
//     */
//    private String title;
//
//    /**
//     * 简介
//     */
//    private String intro;
//
//    /**
//     * 内容
//     */
//    private String content;
//
//    /**
//     * 创建人ID
//     */
//    private Integer createId;
//
//    /**
//     * 创建人名称
//     */
//    private String createName;
//
//    /**
//     * 创建时间
//     */
//    private Date createTime;
//}
