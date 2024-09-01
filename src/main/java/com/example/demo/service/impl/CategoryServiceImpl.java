package com.example.demo.service.impl;

import com.example.demo.mapper.CategoryMapper;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.Result;
import com.example.demo.service.CategoryService;
import com.example.demo.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public void add(Category category) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer UserId = (Integer) map.get("id");
        category.setCreateUser(UserId);
        categoryMapper.add(category);
    }

    @Override
    public List<Category> list(Category category) {
        return categoryMapper.list(category);
    }

    @Override
    public void edit(Category category) {
        categoryMapper.edit(category);
    }

    @Override
    public Category detail(int id) {
        return categoryMapper.detail(id);
    }
}
