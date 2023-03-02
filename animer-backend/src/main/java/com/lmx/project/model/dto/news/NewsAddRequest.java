package com.lmx.project.model.dto.news;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName news
 */

@Data
public class NewsAddRequest implements Serializable {


    /**
     * 新闻名称
     */
    private String name;

    /**
     * 新闻url地址
     */
    private String content ;

    /**
     * 发布时间
     */
    private Date releasetime;

    /**
     * 封面图片
     */
    private String coverimg;

    /**
     * 新闻内容
     */
    private String newscontent;


}