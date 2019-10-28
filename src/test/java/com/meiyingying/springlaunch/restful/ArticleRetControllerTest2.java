package com.meiyingying.springlaunch.restful;


import com.meiyingying.springlaunch.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
//在容器下进行测试Resource
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ArticleRetControllerTest2 {

    @Resource
    private MockMvc mockMvc;

    @Resource
    ArticleRestService articleRestService;

    @Test
    public void saveArticle() throws Exception{
        String article = "{\n" +
                " \"id\":1,\n" +
                "\"author\":\"没隐隐\",\n"+
                "\"title\":\"手把手教你开发spring\",\n"+
                "\"content\":\"c\",\n"+
                "\"createTime\":\"2019-09-09 12:09:21\",\n"+
                "\"reader\":[{\"name\":\"张政豪\",\"age\":12},{\"name\":\"曹红梅\",\"age\":12}]"+
                "}";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST,"/rest/articles")
                .contentType("application/json").content(article))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(12))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("没隐隐"))
                .andDo(print())
                .andReturn();

        log.info(result.getResponse().getContentAsString());

    }


}
