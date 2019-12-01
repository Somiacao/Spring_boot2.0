package com.meiyingying.springlaunch.service;


import com.meiyingying.springlaunch.model.ArticleVO;

import java.util.List;

public interface ArticleRestJPAService {
    ArticleVO save(ArticleVO articleVO);

    void deleteArticle(Long id);

    void updateArticle(ArticleVO articleVO);

    ArticleVO getArticle(Long id);

    List<ArticleVO> getAll();
}
