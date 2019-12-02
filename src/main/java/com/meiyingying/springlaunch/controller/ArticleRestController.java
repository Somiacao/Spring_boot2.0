package com.meiyingying.springlaunch.controller;

import com.meiyingying.springlaunch.model.AjaxResponse;
import com.meiyingying.springlaunch.model.ArticleVO;
import com.meiyingying.springlaunch.service.ArticleRestJPAService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Slf4j
//对这个类的所有方法返回json、xml等格式的相应
@RequestMapping("/rest")
@Controller
public class ArticleRestController {

    @Resource(name = "articleRestJPAServiceImpl")
    ArticleRestJPAService articleRestJPAService;

    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "Articles", httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = AjaxResponse.class),
            @ApiResponse(code = 400, message = "用户输入错误", response = AjaxResponse.class),
            @ApiResponse(code = 500, message = "系统内部错误", response = AjaxResponse.class)
    })
    @RequestMapping(value = "/articles", method = POST, produces = "application/json")
//    @PostMapping(value = "/articles")
    public @ResponseBody AjaxResponse saveArticle(@RequestBody ArticleVO articleVO){

        articleRestJPAService.save(articleVO);

        log.info("saveArticle:{}", articleVO);

        return AjaxResponse.success(articleVO);
    }

    @RequestMapping(value = "/articles/{id}", method = DELETE, produces = "application/json")
//    @DeleteMapping(value = "/articles/{id}")
    public @ResponseBody AjaxResponse deleteArticle(@PathVariable Long id){
        log.info("deleteArticle:{}"+id);
        articleRestJPAService.deleteArticle(id);
        System.out.println("成功");
        return AjaxResponse.success(id);
    }

    @RequestMapping(value = "/articles/{id}", method = PUT, produces = "application/json")
//    @PutMapping(value = "/articles/{id}")
    public @ResponseBody AjaxResponse updateArticle(@PathVariable Long id, @RequestBody ArticleVO articleVO){
        articleVO.setId(id);

        log.info("updateArticle:{}", articleVO);
        articleRestJPAService.updateArticle(articleVO);

        return AjaxResponse.success(id);
    }

    @RequestMapping(value = "/articles/{id}", method = GET, produces = "application/json")
//    @GetMapping(value = "/articles/{id}")
    public @ResponseBody AjaxResponse getArticle(@PathVariable Long id){

//        ArticleVO articleVO = ArticleVO.builder().id(1L).author("梅嘤嘤").content("Springboot学习疗法").createTime(new Date()).title("Springboot").build();

        ArticleVO articleVO = articleRestJPAService.getArticle(id);
        log.info("getArticle:{}", articleVO);

        return AjaxResponse.success(articleVO);
    }

    @GetMapping(value = "/articles")
    public @ResponseBody AjaxResponse getAll(){
        List<ArticleVO> ArticleList = articleRestJPAService.getAll();
        return AjaxResponse.success(ArticleList);
    }





}
