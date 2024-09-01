package com.example.demo.service.impl;

import com.example.demo.mapper.ArticleMapper;
import com.example.demo.pojo.Article;
import com.example.demo.pojo.Page;
import com.example.demo.service.ArticleService;
import com.example.demo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;
    @Override
    public Page<Article> list(Article article) {
        Page<Article> result = new Page<Article>();
        result.setCurrentPage(article.getCurrentPage());
        result.setPageSize(article.getPageSize());
        result.setTotal(articleMapper.count());
        article.setOffset(article.getPageSize() * (article.getCurrentPage() - 1));
        result.setList(articleMapper.list(article));
        return result;
    }

    @Override
    public void add(Article article) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer UserId = (Integer) map.get("id");
        article.setCreateUser(UserId);
        articleMapper.add(article);
    }

    @Override
    public void edit(Article article) {
        articleMapper.edit(article);
    }

    @Override
    public Article detail(Integer id) {
        return articleMapper.detail(id);
    }

    @Override
    public void delete(Integer id) {
        articleMapper.delete(id);
    }
}
