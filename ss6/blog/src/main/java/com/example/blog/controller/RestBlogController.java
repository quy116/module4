package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.repository.ICategory;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    private ICategoryService categoryService;

    @GetMapping("api/showList")
    public ResponseEntity<List<Blog>> showList() {
        List<Blog> list = blogService.list();
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @DeleteMapping("api/delete")
    public ResponseEntity<?> delete(@RequestParam int id){
        blogService.deleteFindId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
