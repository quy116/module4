package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired


    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> showList() {
        return iBlogRepository.findAll();
    }

    @Override
    public void add(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void deleteFindId(int id) {
        iBlogRepository.deleteById(id) ;
    }

    @Override
    public Blog editfindId(Integer id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public void edit(Blog blog) {
        iBlogRepository.save(blog);
    }
}
