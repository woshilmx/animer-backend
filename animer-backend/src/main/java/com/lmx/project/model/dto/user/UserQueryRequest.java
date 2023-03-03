package com.lmx.project.model.dto.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.lmx.project.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户查询请求
 *
 * @author lmx
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryRequest extends PageRequest implements Serializable {
    /**
     * 用户ID
     */

    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * openid
     * */
    private String openid;



    /**
     * 邮箱
     */
    private String email;



    /**
     * 积分
     */
    private Integer integral;



    private static final long serialVersionUID = 1L;
}