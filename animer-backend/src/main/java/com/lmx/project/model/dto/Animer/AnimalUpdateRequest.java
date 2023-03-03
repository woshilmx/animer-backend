package com.lmx.project.model.dto.Animer;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

/**
 * 动物
 *
 * @TableName animal
 */

@Data
public class AnimalUpdateRequest implements Serializable {
    /**
     * 动物编号
     */

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

//    /**
//     * 图片
//     */
//    private String picture;

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
* 图片
* */
    private MultipartFile image;

}