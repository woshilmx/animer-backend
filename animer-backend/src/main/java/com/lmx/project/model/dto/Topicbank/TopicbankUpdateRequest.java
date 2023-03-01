package com.lmx.project.model.dto.Topicbank;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

@Data
public class TopicbankUpdateRequest {
    /**
     * id
     */

    private Long id;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 答案
     */
    private String answer;

    /**
     * 解析
     */
    private String analysis;

    /**
     * 所属关卡
     */
    private Integer belonglevel;


}
