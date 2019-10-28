package com.meiyingying.springlaunch.controller;

import com.meiyingying.springlaunch.model.AjaxResponse;
import com.meiyingying.springlaunch.model.Article;
import com.meiyingying.springlaunch.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Slf4j
//对这个类的所有方法返回json、xml等格式的相应
@RestController
@RequestMapping("/rest")
public class ArticleRestController {

    @Resource
    ArticleRestService articleRestService;

//    @RequestMapping(value = "/articles", method = POST, produces = "application/json")
    @PostMapping(value = "/articles")
    public AjaxResponse saveArticle(@RequestBody Article article){

        articleRestService.saveArticle(article);

        log.info("saveArticle:{}",article);

        return AjaxResponse.success(article);
    }

    @RequestMapping(value = "/articles/{id}", method = DELETE, produces = "application/json")
//    @DeleteMapping(value = "/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id){
        log.info("deleteArticle:{}"+id);

        return AjaxResponse.success(id);
    }

    @RequestMapping(value = "/articles/{id}", method = PUT, produces = "application/json")
//    @PutMapping(value = "/articles/{id}")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article){
        article.setId(id);

        log.info("updateArticle:{}",article);

        return AjaxResponse.success(id);
    }

    @RequestMapping(value = "/articles/{id}", method = GET, produces = "application/json")
//    @GetMapping(value = "/articles/{id}")
    public AjaxResponse getArticle(@PathVariable Long id){

        Article article = Article.builder().id(1L).author("梅嘤嘤").content("Springboot学习疗法").createTime(new Date()).title("Springboot").build();

        log.info("getArticle:{}",article);

        return AjaxResponse.success(id);
    }


}
