package com.meiyingying.springlaunch.jpa;

import com.meiyingying.springlaunch.Dao.Article;
import com.meiyingying.springlaunch.Dao.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPAKeyWordTest {

    @Resource
    private ArticleRepository articleRepository;

    @Test
    public void userTest(){
        Article article = articleRepository.findByAuthor("曹红梅");
        System.out.println(article);
    }
}
