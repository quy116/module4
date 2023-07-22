package com.example.bai1.repository;

import com.example.bai1.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> listProduct();
    void createRepository(Product product);
    Product getProduct(int id);

    void edit(Product product);

    void delete(int id);

    Product findName(String name);
}
