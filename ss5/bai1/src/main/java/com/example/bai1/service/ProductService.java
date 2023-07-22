package com.example.bai1.service;

import com.example.bai1.model.Product;
import com.example.bai1.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> ShowList() {
        List<Product> list = repository.listProduct();
        return list;
    }

    @Override
    public void createSerivce(Product product) {
        repository.createRepository(product);
    }

    @Override
    public Product getProduct(int id) {
        return repository.getProduct(id);
    }

    @Override
    public void edit(Product product) {
        repository.edit(product);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Product findName(String name) {
        Product product = repository.findName(name);
        return product;
    }
}
