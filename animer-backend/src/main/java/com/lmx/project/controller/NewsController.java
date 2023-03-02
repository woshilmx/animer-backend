package com.lmx.project.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmx.project.common.BaseResponse;
import com.lmx.project.common.ErrorCode;
import com.lmx.project.common.ResultUtils;
import com.lmx.project.exception.BusinessException;
import com.lmx.project.model.dto.news.NewsAddRequest;
import com.lmx.project.model.dto.news.NewsQueryRequest;
import com.lmx.project.model.dto.news.NewsUpdateRequest;
import com.lmx.project.model.entity.News;
import com.lmx.project.service.NewsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Resource
    private NewsService newsService;


    /**
     * 增加
     */
    @PostMapping
    public BaseResponse<Boolean> addNews(@RequestBody NewsAddRequest newsAddRequest) {
        if (newsAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        if (!StringUtils.isNotBlank(newsAddRequest.getNewscontent())) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "所属单位不能为空");
        }
        if (!StringUtils.isNotBlank(newsAddRequest.getContent())) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "新闻url不能为空");
        }

        if (!StringUtils.isNotBlank(newsAddRequest.getName())) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "新闻标题不能为空");
        }

        if (newsAddRequest.getReleasetime() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "发布时间不能为空");
        }

        News target = new News();
        BeanUtils.copyProperties(newsAddRequest, target);

        boolean save = newsService.save(target);
        return ResultUtils.success(save);
    }

    /**
     * 删除
     */

    @DeleteMapping()
    public BaseResponse<Boolean> deleteNews(Long id) {
        if (id == null || id == 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean save = newsService.removeById(id);
        return ResultUtils.success(save);
    }

    /**
     * 修改
     */
    @PostMapping("update")
    public BaseResponse<Boolean> UpdateNews(@RequestBody NewsUpdateRequest newsUpdateRequest) {
        if (newsUpdateRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        if (newsUpdateRequest.getId() == 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "id属性为必须值");
        }

        News target = new News();
        BeanUtils.copyProperties(newsUpdateRequest, target);

        boolean save = newsService.updateById(target);
        return ResultUtils.success(save);
    }

    /**
     * 根据id查询
     */
    @GetMapping()
    public BaseResponse<News> getNews(Long id) {
        if (id == null || id == 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        News save = newsService.getById(id);
        return ResultUtils.success(save);
    }

    /**
     * 分页条件查询
     */

    @GetMapping("list")
    public BaseResponse<IPage<News>> getNews(@RequestBody NewsQueryRequest newsQueryRequest) {
        if (newsQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        if (newsQueryRequest.getPageSize() == 0 || newsQueryRequest.getCurrent() == 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求页数不合法");
        }


        LambdaQueryWrapper<News> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        if (StringUtils.isNotBlank(newsQueryRequest.getNewscontent())) {
            lambdaQueryWrapper.like(News::getNewscontent,newsQueryRequest.getNewscontent());
        }


        if (StringUtils.isNotBlank(newsQueryRequest.getName())) {
            lambdaQueryWrapper.like(News::getName,newsQueryRequest.getName());
        }

//        if (newsQueryRequest.getReleasetime() == null) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR, "发布时间不能为空");
//        }


        IPage<News> newsPage = new Page<>(newsQueryRequest.getCurrent(), newsQueryRequest.getPageSize());
        IPage<News> page = newsService.page(newsPage, lambdaQueryWrapper);
        return ResultUtils.success(page);
    }

}
