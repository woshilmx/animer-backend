package com.lmx.project.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import nonapi.io.github.classgraph.json.Id;

/**
 * 动物
 * @TableName animal
 */
@TableName(value ="animal")
@Data
@ToString
public class Animal implements Serializable {
    /**
     * 动物编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 动物名称
     */
    private String name;

    /**
     * 分类编号
     */
    private Long categoryid;

    /**
     * 动物简介
     */
    private String introduction;

    /**
     * 图片
     */
    private String picture;

    /**
     * 濒危等级
     */
    private String endangeredlevel;

    /**
     * 形态描述
     */
    private String morphologydescription;

    /**
     * 生活习性
     */
    private String habit;

    /**
     * 生活地理环境
     */
    private String geographicalenvironment;

    /**
     * 分布范围
     */
    private String distributionrange;

//    /**
//     * 各界报道
//     */
//    private String report;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isdelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}