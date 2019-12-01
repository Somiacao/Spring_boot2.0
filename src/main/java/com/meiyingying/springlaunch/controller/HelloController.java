package com.meiyingying.springlaunch.controller;

import com.meiyingying.springlaunch.model.ArticleVO;
import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
public class HelloController {

//    private static final Logger log = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping("/hello")
    public ArticleVO hello(){

        ArticleVO articleVO1 = ArticleVO.builder().id(3L).author("莫言").build();
        log.info("测试一下"+ articleVO1);
        return articleVO1;
    }
}
