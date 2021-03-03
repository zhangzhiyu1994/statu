package com.status.controller;

import com.status.StatusApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

/**
 * 用户测试类
 * @author 张志宇
 * @version V1.0
 * @Package com.status.controller
 * @date 2021/2/24 18:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StatusApplication.class)
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserController userController;
    @Test
    void login() {

    }

    @Test
    public void testVideoListApi()throws Exception{

        MvcResult mvcResult =  mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        int status = mvcResult.getResponse().getStatus();

        System.out.println(status);

        //会乱码
        //String result = mvcResult.getResponse().getContentAsString();

        // 使用下面这个，增加 编码 说明，就不会乱码打印
        String result = mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));

        System.out.println(result);

    }

}