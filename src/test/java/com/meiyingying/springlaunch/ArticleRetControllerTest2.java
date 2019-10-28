package com.meiyingying.springlaunch;

import com.meiyingying.springlaunch.controller.ArticleRestController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@SpringBootTest
public class ArticleRetControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleRestController()).build();
    }

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
