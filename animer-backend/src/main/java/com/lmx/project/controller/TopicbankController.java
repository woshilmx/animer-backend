package com.lmx.project.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmx.project.common.BaseResponse;
import com.lmx.project.common.ErrorCode;
import com.lmx.project.common.ResultUtils;
import com.lmx.project.exception.BusinessException;
import com.lmx.project.model.dto.Topicbank.TopicBankQueryRequest;
import com.lmx.project.model.dto.Topicbank.TopicbankAddRequest;
import com.lmx.project.model.dto.Topicbank.TopicbankUpdateRequest;
import com.lmx.project.model.dto.usertopicbank.UserTopicBankAddRequest;
import com.lmx.project.model.entity.Topicbank;
import com.lmx.project.model.entity.Usertopicbank;
import com.lmx.project.service.TopicbankService;
import com.lmx.project.service.UsertopicbankService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang3.StringUtils;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 李满祥
 * 题库
 */
@RestController
@RequestMapping("/topicbank")
@ResponseBody
public class TopicbankController {
    /**
     * 题库服务
     */
    @Resource
    private TopicbankService topicbankService;

    /**
     * 用户题库服务
     */
    @Resource
    private UsertopicbankService usertopicbankService;

    /**
     * 添加题库信息
     */
    @PostMapping
    public BaseResponse<Long> addTopicbank(@RequestBody TopicbankAddRequest topicbankAdd) {

        if (topicbankAdd == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        if (topicbankAdd.getType() == 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "题目类型错误");
        }
        if (StringUtils.isNotBlank(topicbankAdd.getAnswer())) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "答案不能为空");
        }

        if (StringUtils.isNotBlank(topicbankAdd.getAnalysis())) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "解析不能为空");
        }
        if (topicbankAdd.getBelonglevel() == 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "所属关卡错误");
        }

        Topicbank topicbank = new Topicbank();
        BeanUtils.copyProperties(topicbankAdd, topicbank);
        topicbankService.save(topicbank);
        return ResultUtils.success(topicbank.getId());
    }

    /**
     * 修改题库信息
     */
    @PutMapping
    public BaseResponse<Boolean> updateTopicBank(@RequestBody TopicbankUpdateRequest topicbankUpdateRequest) {
// 更新id不能为空
        if (topicbankUpdateRequest.getId() == null || topicbankUpdateRequest.getId() == 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "id不能为空");
        }
        Topicbank topicbank = new Topicbank();
// 将修改的请求体变为topicbank
        BeanUtils.copyProperties(topicbankUpdateRequest, topicbank);

        try {
            topicbankService.updateById(topicbank);

            return ResultUtils.success(true);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }


    }

    /**
     * 删除题目信息
     */
    @DeleteMapping
    public BaseResponse<Boolean> deleteTopicBank(Long id) {
        if (id == 0L) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "题库id不能为0");
        }

        boolean b = topicbankService.removeById(id);
        if (b) {
            return ResultUtils.success(b);
        }
        throw new BusinessException(ErrorCode.SYSTEM_ERROR);

    }


    /**
     * 查询单个题目信息
     */
    @GetMapping
    public BaseResponse<Topicbank> getTopicBank(Long id) {
        if (id == 0L) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "题库id不能为0");
        }

        Topicbank topicbank = topicbankService.getById(id);
        if (topicbank != null) {
            return ResultUtils.success(topicbank);
        }

        throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "题目不存在");


    }


    /**
     * 查询多个题目信息
     */
    @PostMapping("list")
    public BaseResponse<IPage<Topicbank>> getTopicBank(@RequestBody TopicBankQueryRequest topicBankQueryRequest) {

        LambdaQueryWrapper<Topicbank> topicbankLambdaQueryWrapper = new LambdaQueryWrapper<>();

        Topicbank topicbank = new Topicbank();
        BeanUtils.copyProperties(topicBankQueryRequest, topicbank);

//        根据类型查询
        if (topicbank.getType() != 0 && topicbank.getBelonglevel() != null) {
            topicbankLambdaQueryWrapper.eq(Topicbank::getType, topicbank.getType());
        }
        if (0 != topicbank.getBelonglevel() && topicbank.getBelonglevel() != null) {

            topicbankLambdaQueryWrapper.eq(Topicbank::getBelonglevel, topicbank.getBelonglevel());
        }

        IPage<Topicbank> page = new Page<>(topicBankQueryRequest.getCurrent(),
                topicBankQueryRequest.getPageSize());
        IPage<Topicbank> resultpage = topicbankService.page(page, topicbankLambdaQueryWrapper);
        return ResultUtils.success(resultpage);
    }


    /**
     * 题目答对状态
     */
    @PostMapping("usertopicbank")
    public BaseResponse<Boolean> addUserTopicBank(@RequestBody UserTopicBankAddRequest userTopicBankAddRequest) {
        //   用户id
        if (userTopicBankAddRequest.getUserid() == null || userTopicBankAddRequest.getUserid() == 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 问题id
        if (userTopicBankAddRequest.getQuestionid() == null || userTopicBankAddRequest.getQuestionid() == 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //    题目状态
        if (userTopicBankAddRequest.getStatus() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        // 根据userid questionid查询是否已作答
        LambdaQueryWrapper<Usertopicbank> queryWrapper = new LambdaQueryWrapper<>();

        List<Usertopicbank> list = usertopicbankService.list(queryWrapper);
//         如果表中以有说明已经作答，直接返回
        if (list != null && list.size() > 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "该问题已作答");
        }
        //           TODO 根据用户id 查询该用户是否存在
//        查询题目是否存在
        Usertopicbank byId = usertopicbankService.getById(userTopicBankAddRequest.getQuestionid());
        if (byId == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "题目不存在");
        }
        Usertopicbank target = new Usertopicbank();

        BeanUtils.copyProperties(userTopicBankAddRequest, target);



        if (userTopicBankAddRequest.getStatus()==1){
            //        TODO 用户答对加积分
        }
        boolean save = usertopicbankService.save(target);

        return ResultUtils.success(save);
    }


}
