package com.meiyingying.springlaunch.dao;


import com.meiyingying.springlaunch.model.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleJDBCDAO {


//    保存文章
    public void save(Article article,JdbcTemplate jdbcTemplate){
        jdbcTemplate.update("INSERT INTO article(id, author, title, content, create_time) VALUE(?,?,?,?,?)",
                article.getId(),
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());
    }

//  删除文章
    public void deleteById(Long id,JdbcTemplate jdbcTemplate){
        jdbcTemplate.update("DELETE FROM article WHERE id=?",new Object[]{id});
    }

//    更新文章
    public void updateById(Article article,JdbcTemplate jdbcTemplate){
        jdbcTemplate.update("UPDATE article SET author = ?, title = ?, content = ?, create_time = ? WHERE id = ?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId());
    }

//    根据id查找文章
    public Article findById(Long id,JdbcTemplate jdbcTemplate){
        return (Article)jdbcTemplate.queryForObject("SELECT * FROM article where id = ?",
                new Object[]{id},new BeanPropertyRowMapper(Article.class));
    }

//    查询所有
    public List<Article> finfAll(JdbcTemplate jdbcTemplate){
        return (List<Article>)jdbcTemplate.query("SELECT * FROM article", new BeanPropertyRowMapper(Article.class));
    }


}
