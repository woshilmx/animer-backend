package com.lmx.project.model.dto.document;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

/**
 * 文献表
 *
 * @TableName document
 */

@Data
public class DocumentAddRequest implements Serializable {


    /**
     * 标题
     */
    private String title;

    /**
     * 动物id
     */
    private Long animalid;

    /**
     * 文献url
     */
    private String url;

    /**
     * 发布时间
     */
    private Date publishtime;

    /**
     * 作者
     */
    private String author;

    /**
     * 期刊
     */
    private String periodical;
    /**
     * 文档信息
     */
    private MultipartFile documentfile;


}