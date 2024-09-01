package com.example.demo.mapper;

import com.example.demo.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    List<Article> list(Article article);

    void add(Article article);

    void edit(Article article);

    Article detail(Integer id);

    int count();

    void delete(Integer id);
}
