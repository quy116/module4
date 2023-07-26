package com.example.blog.service;

import com.example.blog.model.Category;
import com.example.blog.repository.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategory iCategory;
    @Override
    public List<Category> showList() {
        return iCategory.findAll();
    }
}
