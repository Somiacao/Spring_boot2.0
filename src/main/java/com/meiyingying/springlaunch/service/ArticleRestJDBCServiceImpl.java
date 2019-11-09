package com.meiyingying.springlaunch.service;

import com.meiyingying.springlaunch.dao.ArticleJDBCDAO;
import com.meiyingying.springlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Slf4j
public class ArticleRestJDBCServiceImpl implements ArticleRestJDBCService{

    @Resource
    ArticleJDBCDAO articleJDBCDAO;

    @Transactional
    @Override
    public Article saveArticle(Article article) {
        articleJDBCDAO.save(article);
        return article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleJDBCDAO.updateById(article);
    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDAO.findById(id);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.finfAll();
    }
}
