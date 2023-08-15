package com.kirito.test;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.kirito.test.types.ParamBO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestWebTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGet() throws Exception {
        // GET接口测试
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/rest/get/1"))
                .andReturn();
        printMvcResult(mvcResult);
    }

    @Test
    public void testPost() throws Exception {
        // 参数模型
        JsonMapper jsonMapper = new JsonMapper();
        ParamBO param = new ParamBO(null, "单元测试", new Date());
        String paramJson = jsonMapper.writeValueAsString(param);
        // Post接口测试
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/rest/post")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(paramJson)).andReturn();
        printMvcResult(mvcResult);
    }

    @Test
    public void testPut() throws Exception {
        // 参数模型
        JsonMapper jsonMapper = new JsonMapper();
        ParamBO param = new ParamBO(7, "Junit组件", new Date());
        String paramJson = jsonMapper.writeValueAsString(param);
        // Put接口测试
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/rest/put")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(paramJson)).andReturn();
        printMvcResult(mvcResult);
    }

    @Test
    public void testDelete() throws Exception {
        // Delete接口测试
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.delete("/rest/delete/2"))
                .andReturn();
        printMvcResult(mvcResult);
    }

    /**
     * 打印【MvcResult】信息
     */
    private void printMvcResult(MvcResult mvcResult) throws Exception {
        System.out.println("请求-URI【" + mvcResult.getRequest().getRequestURI() + "】");
        System.out.println("响应-status【" + mvcResult.getResponse().getStatus() + "】");
        System.out.println("响应-content【" + mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8) + "】");
    }
}