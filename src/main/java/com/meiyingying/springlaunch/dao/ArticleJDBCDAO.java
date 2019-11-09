package com.meiyingying.springlaunch.dao;


import com.meiyingying.springlaunch.model.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ArticleJDBCDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

//    保存文章
    public void save(Article article){
        jdbcTemplate.update("INSERT INTO article(author, title, content, createTime) VALUE(?,?,?,?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());
    }

//  删除文章
    public void deleteById(Long id){
        jdbcTemplate.update("DELETE FROM article WHERE id=?",new Object[]{id});
    }

//    更新文章
    public void updateById(Article article){
        jdbcTemplate.update("UPDATE article SET author = ?, title = ?, content = ?, createTime = ?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());
    }

//    根据id查找文章
    public Article findById(Long id){
        return (Article)jdbcTemplate.queryForObject("SELECT * FROM article where id = ?",
                new Object[]{id},new BeanPropertyRowMapper(Article.class));
    }

//    查询所有
    public List<Article> finfAll(){
        return (List<Article>)jdbcTemplate.query("SELECT * FROM article", new BeanPropertyRowMapper(Article.class));
    }


}
