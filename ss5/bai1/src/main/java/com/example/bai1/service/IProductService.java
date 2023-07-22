package com.example.bai1.service;

import com.example.bai1.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> ShowList();
    void createSerivce(Product product);
    Product getProduct(int id);

    void edit(Product product);

    void delete(int id);

    Product findName(String name);
}
