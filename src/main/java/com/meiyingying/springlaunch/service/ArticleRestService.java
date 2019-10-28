package com.meiyingying.springlaunch.service;

import com.meiyingying.springlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ArticleRestService {
    public String saveArticle(Article article){
        log.info("saveArticle:{}",article);
        return "测试";
    }
}
