package com.lmx.project.model.dto.exchange;

import com.lmx.project.common.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户兑换表
 * @TableName userexchange
 */

@Data
public class UserexchangeQueryRequest extends PageRequest implements Serializable {


    /**
     * 用户id
     */
    private Long userid;

    /**
     * 商品id
     */
    private Long goodsid;

    /**
     * 地址
     */
    private String address;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮寄状态 0——未邮寄 1——邮寄
     */
    private Integer status;




}