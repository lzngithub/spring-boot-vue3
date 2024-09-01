package com.example.demo.controller;

import com.example.demo.pojo.Category;
import com.example.demo.pojo.Result;
import com.example.demo.service.CategoryService;
import com.example.demo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/add")
    public Result<Category> add(@RequestBody Category category) {
        categoryService.add(category);
        return Result.success();
    }

    @PostMapping("/list")
    public Result<List<Category>> list(@RequestBody Category category) {
        return Result.success(categoryService.list(category));
    }

    @PostMapping("/edit")
    public Result<Category> edit(@RequestBody Category category) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer UserId = (Integer) map.get("id");
        if (Objects.equals(UserId, category.getCreateUser())) {
            categoryService.edit(category);
            return Result.success();
        }
        return Result.error("无权限");
    }

    @PostMapping("/detail")
    public Result<Category> detail(@RequestBody Integer id) {
        return Result.success(categoryService.detail(id));
    }
}
