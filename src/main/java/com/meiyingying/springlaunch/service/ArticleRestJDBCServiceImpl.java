package com.meiyingying.springlaunch.service;

import com.meiyingying.springlaunch.dao.ArticleJDBCDAO;
import com.meiyingying.springlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Slf4j
public class ArticleRestJDBCServiceImpl implements ArticleRestJDBCService{

    @Resource
    ArticleJDBCDAO articleJDBCDAO;

    @Resource
    JdbcTemplate primaryJdbcTemplate;

    @Resource
    JdbcTemplate secondaryJdbcTemplate;

//    @Transactional
    @Override
    public Article saveArticle(Article article) {
        articleJDBCDAO.save(article,primaryJdbcTemplate);
//        articleJDBCDAO.save(article,secondaryJdbcTemplate);
//        int a = 2/0;
////        System.out.println(a);
        return article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id,primaryJdbcTemplate);
    }

    @Override
    public void updateArticle(Article article) {
        articleJDBCDAO.updateById(article,primaryJdbcTemplate);
    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDAO.findById(id,primaryJdbcTemplate);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.finfAll(primaryJdbcTemplate);
    }
}
