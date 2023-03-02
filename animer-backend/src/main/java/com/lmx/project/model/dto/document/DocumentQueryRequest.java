package com.lmx.project.model.dto.document;

import com.baomidou.mybatisplus.annotation.*;
import com.lmx.project.common.PageRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 文献表
 * @TableName document
 */

@Data
public class DocumentQueryRequest extends PageRequest implements Serializable {



    /**
     * 标题
     */
    private String title;

    /**
     * 动物id
     */
    private Long animalid;



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




}