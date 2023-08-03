package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Optional<Blog> findById(Integer id);
    Page<Blog> findBlogByNameContaining(Pageable pageable, String name);

}
