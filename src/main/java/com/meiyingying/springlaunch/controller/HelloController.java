package com.meiyingying.springlaunch.controller;

import com.meiyingying.springlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

//    private static final Logger log = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping("/hello")
    public Article hello(){

        Article article1 = Article.builder().id(3L).author("莫言").build();

        log.info("测试一下"+article1);

        return article1;
    }
}
