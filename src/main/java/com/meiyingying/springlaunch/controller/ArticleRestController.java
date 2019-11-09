package com.meiyingying.springlaunch.controller;

import com.meiyingying.springlaunch.model.AjaxResponse;
import com.meiyingying.springlaunch.model.Article;
import com.meiyingying.springlaunch.service.ArticleRestJDBCService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @Resource(name = "articleRestJDBCServiceImpl")
    ArticleRestJDBCService articleRestService;

    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "Articles", httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = AjaxResponse.class),
            @ApiResponse(code = 400, message = "用户输入错误", response = AjaxResponse.class),
            @ApiResponse(code = 500, message = "系统内部错误", response = AjaxResponse.class)
    })
    @RequestMapping(value = "/articles", method = POST, produces = "application/json")
//    @PostMapping(value = "/articles")
    public AjaxResponse saveArticle(@RequestBody Article article){
        articleRestService.saveArticle(article);
        return AjaxResponse.success(article);
    }

    @RequestMapping(value = "/articles/{id}", method = DELETE, produces = "application/json")
//    @DeleteMapping(value = "/articles/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id){
        articleRestService.deleteArticle(id);
        return AjaxResponse.success(id);
    }

    @RequestMapping(value = "/articles/{id}", method = PUT, produces = "application/json")
//    @PutMapping(value = "/articles/{id}")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article){
        articleRestService.updateArticle(article);
        return AjaxResponse.success(article);
    }

    @RequestMapping(value = "/articles/{id}", method = GET, produces = "application/json")
//    @GetMapping(value = "/articles/{id}")
    public AjaxResponse getArticle(@PathVariable Long id){
        return AjaxResponse.success(articleRestService.getArticle(id));
    }

    @RequestMapping(value = "/articles", method = GET, produces = "application/json")
    public AjaxResponse getAll(){
        return AjaxResponse.success(articleRestService.getAll());
    }


}
