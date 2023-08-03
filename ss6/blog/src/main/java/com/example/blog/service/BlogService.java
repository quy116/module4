package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired


    private IBlogRepository iBlogRepository;


    @Override
    public Page<Blog> showList(Pageable pageable, String search) {
        return iBlogRepository.findBlogByNameContaining(pageable, search);
    }

    @Override
    public List<Blog> list() {
        return iBlogRepository.findAll();
    }

    @Override
    public void add(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void deleteFindId(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Blog editfindId(Integer id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public void edit(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public List<Blog> findName(String name) {
        List<Blog> list = new ArrayList<>();
        for (int i = 0 ;i < list().size(); i++){
            if (list().get(i).getName().contains(name)){
                list.add(list().get(i));
            }
        }
        return list;
    }
}
