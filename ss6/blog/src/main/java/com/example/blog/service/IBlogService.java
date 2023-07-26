package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> showList(Pageable pageable,String name);
    void add(Blog blog);

    void deleteFindId(int id);

    Blog editfindId(Integer id);
    void edit(Blog blog);
}
