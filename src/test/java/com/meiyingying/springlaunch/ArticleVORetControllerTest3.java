package com.meiyingying.springlaunch;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.meiyingying.springlaunch.model.ArticleVO;
import com.meiyingying.springlaunch.service.ArticleRestJPAService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
//在容器下进行测试Resource
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest
public class ArticleVORetControllerTest3 {

    @Resource
    private MockMvc mockMvc;

    @MockBean
    ArticleRestJPAService articleRestJPAService;



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
        ObjectMapper objectMapper = new ObjectMapper();
        ArticleVO articleVOObj = objectMapper.readValue(article, ArticleVO.class);

//        打桩
        when(articleRestJPAService.save(articleVOObj)).thenReturn(articleVOObj);


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
