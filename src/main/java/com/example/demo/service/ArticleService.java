package com.example.demo.service;

import com.example.demo.pojo.Article;
import com.example.demo.pojo.Page;

import java.util.List;

public interface ArticleService {

    Page<Article> list(Article article);

    void add(Article article);

    void edit(Article article);

    Article detail(Integer id);

    void delete(Integer id);
}
