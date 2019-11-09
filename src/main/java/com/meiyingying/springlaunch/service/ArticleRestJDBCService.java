package com.meiyingying.springlaunch.service;

import com.meiyingying.springlaunch.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleRestJDBCService {
    public Article saveArticle(Article article);

    public void deleteArticle(Long id);

    public void updateArticle(Article article);

    public Article getArticle(Long id);

    public List<Article> getAll();
}
