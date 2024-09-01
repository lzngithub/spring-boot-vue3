package com.example.demo.controller;

import com.example.demo.pojo.Article;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.Page;
import com.example.demo.pojo.Result;
import com.example.demo.service.ArticleService;
import com.example.demo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping("/add")
    public Result<Article> add(@RequestBody Article article) {
        articleService.add(article);
        System.out.println("完成");
        return Result.success();
    }

    @PostMapping("/list")
    public Result<Page<Article>> list(@RequestBody Article article) {
        return Result.success(articleService.list(article));
    }

    @PostMapping("/edit")
    public Result<Article> edit(@RequestBody Article article) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer UserId = (Integer) map.get("id");
        if (Objects.equals(UserId, article.getCreateUser())) {
            articleService.edit(article);
            return Result.success();
        }
        return Result.error("无权限");
    }

    @GetMapping("/detail/{id}")
    public Result<Article> detail(@PathVariable("id") Integer id) {
        return Result.success(articleService.detail(id));
    }
    @DeleteMapping("/delete/{id}")
    public Result<Article> delete(@PathVariable("id") Integer id) {
        articleService.delete(id);
        return Result.success();
    }
}
