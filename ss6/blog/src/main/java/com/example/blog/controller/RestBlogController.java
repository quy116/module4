package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.repository.ICategory;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
//    @GetMapping("api/showList")
//    public ResponseEntity<?> showList(@RequestParam(defaultValue = "0") int page,
//                           @RequestParam(defaultValue = "") String search
//            , Model model){
//        Pageable pageable = PageRequest.of(page,2, Sort.by("date").descending());
//        Page<Blog> blogPage = blogService.showList(pageable,search);
//        return new ResponseEntity<>(blogPage,HttpStatus.OK);
//    }
    @DeleteMapping("api/delete")
    public ResponseEntity<?> delete(@RequestParam int id){
        blogService.deleteFindId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("api/findName")
    public ResponseEntity<List<Blog>> findName(@RequestParam String name){
      List<Blog> list =  blogService.findName(name);
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
