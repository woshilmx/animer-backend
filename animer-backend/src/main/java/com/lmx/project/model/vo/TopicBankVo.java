package com.lmx.project.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;
@Data
public class TopicBankVo {
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
    * 问题
    * */

    private String question;

    /**
     * 所属关卡
     */
    private Integer belonglevel;


    /**
     * 用户ID
     */
    private Long userid;



    /**
     * 状态：0-错误 1-正确
     */
    private Integer status;

}
