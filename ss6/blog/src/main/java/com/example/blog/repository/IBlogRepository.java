package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Optional;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Optional<Blog> findById(Integer id);
    Page<Blog> findBlogsByNameContains(Pageable pageable, String name);
}
