package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> showList();
    void add(Blog blog);

    void deleteFindId(int id);

    Blog editfindId(Integer id);
    void edit(Blog blog);
}
