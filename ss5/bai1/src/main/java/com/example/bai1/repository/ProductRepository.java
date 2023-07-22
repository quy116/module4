package com.example.bai1.repository;

import com.example.bai1.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "macbook", 3888, "ok", "apple"));
        productList.add(new Product(2, "ipad", 1000, "ok", "apple"));
        productList.add(new Product(3, "iphone", 1200, "ok", "apple"));
        productList.add(new Product(4, "ipod", 300, "ok", "apple"));
    }

    @Override
    public List<Product> listProduct() {
        return productList;
    }

    @Override
    public void createRepository(Product product) {
        productList.add(product);
    }

    @Override
    public Product getProduct(int id) {
        Product product = null;
        for (Product p : productList) {
            if (id == p.getId()) {
                product = p;
            }
        }
        return product;
    }

    @Override
    public void edit(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
//
                productList.set(i, product);
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
            }
        }
    }

    @Override
    public Product findName(String name) {
        Product product = null;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(name)) {
                product = productList.get(i);
            }
        }


        return product;
    }
}
