package com.lmx.project.model.dto.news;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName news
 */

@Data
public class NewsUpdateRequest implements Serializable {
    /**
     * 新闻编号
     */
    @TableId
    private Long id;

    /**
     * 新闻名称
     */
    private String name;

    /**
     * 内容
     */
    private String content;

    /**
     * 发布时间
     */
    private String releasetime;

    /**
     * 封面图片
     */
    private String coverimg;

    /**
     * 新闻内容
     */
    private String newscontent;

    /**
    * 图片文件
    * */

    private MultipartFile  coverFile;



}