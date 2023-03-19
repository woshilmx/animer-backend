package com.lmx.project.controller;

import com.lmx.project.common.BaseResponse;
import com.lmx.project.common.ErrorCode;
import com.lmx.project.common.ResultUtils;
import com.lmx.project.exception.BusinessException;
import com.lmx.project.model.enums.ImageMode;
import com.lmx.project.until.AnimalIdentUntil;
import com.lmx.project.until.ImageChangeUntil;
import io.swagger.annotations.Api;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("aisc")
@Api("动物识别模块")
public class AnimerImageSearchAndIndefyController {
    @Resource
    private AnimalIdentUntil animalIdentUntil;

    @Resource
    private ImageChangeUntil imageChangeUntil;

    /**
     * 实现根据图片检测动物信息
     */
    @PostMapping("indefy")
    public BaseResponse<String> IdenfyAnimerByImage(@RequestParam MultipartFile animerimage) throws IOException {
        if (animerimage.getSize() >= 4 * 1024 * 1024) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "文件大小需要小于4MB");
        }

        InputStream inputStream = animerimage.getInputStream();
        JSONObject animerByImage = animalIdentUntil.getAnimerByImage(inputStream);
        return ResultUtils.success(animerByImage.toString());

    }

    /**
     * 实现图像风格转化
     */
    @PostMapping("change")
    public BaseResponse<String> ChangeAnimerByImage(@RequestParam MultipartFile animerimage, @RequestParam int mode) throws IOException {
        if (animerimage.getSize() >= 4 * 1024 * 1024) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "文件大小需要小于4MB");
        }

        InputStream inputStream = animerimage.getInputStream();

        String s = imageChangeUntil.imageChange(inputStream, ImageMode.cartoon);

        if (s != null) {
            return ResultUtils.success(s);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }

    }

    /**
     * 获取所有的能转化的风格样式
     */
    @GetMapping("mode")
    public BaseResponse<Map<String,String>> getImageMode() {
        Map<String,String> values = ImageMode.getValues();
        return ResultUtils.success(values);
    }
}
