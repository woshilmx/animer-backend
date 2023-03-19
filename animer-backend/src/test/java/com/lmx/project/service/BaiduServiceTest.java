package com.lmx.project.service;

import com.lmx.project.mapper.UsertopicbankMapper;
import com.lmx.project.model.dto.exchange.UserexchangeQueryRequest;
import com.lmx.project.model.entity.User;
import com.lmx.project.model.enums.ImageMode;
import com.lmx.project.until.AnimalIdentUntil;
import com.lmx.project.until.FileUntil;
import com.lmx.project.until.ImageChangeUntil;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.UUID;

/**
 * 用户服务测试
 *
 * @author lmx
 */
@SpringBootTest
class BaiduServiceTest {

    @Resource
    private AnimalIdentUntil animalIdentUntil;
    @Resource
    private FileUntil fileUntil;
    @Resource
    private ImageChangeUntil imageChangeUntil;

    @Test
    public void te() throws IOException, JSONException {
        FileInputStream fileInputStream = new FileInputStream("E:\\javaProject2023\\ead\\animer-backend\\src\\main\\resources\\下载.png");
        JSONObject animerByImage = animalIdentUntil.getAnimerByImage(fileInputStream);
        System.out.println(animerByImage);
    }

    @Test
    public void filetest() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:\\javaProject2023\\ead\\animer-backend\\src\\main\\resources\\下载.png");
        String s = imageChangeUntil.imageChange(fileInputStream, ImageMode.pencil);
        System.out.println(s);
    }

}