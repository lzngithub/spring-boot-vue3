package com.example.demo.mapper;

import com.example.demo.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    void add(Category category);

    List<Category> list(Category category);

    void edit(Category category);

    Category detail(int id);
}
