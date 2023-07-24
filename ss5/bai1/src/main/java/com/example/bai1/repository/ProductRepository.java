package com.example.bai1.repository;

import com.example.bai1.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> listProduct() {
        TypedQuery<Product> productTypedQuery = entityManager.createQuery("from Product ", Product.class);
        return productTypedQuery.getResultList();
    }

    @Transactional
    @Override
    public void createRepository(Product product) {
        try {
            entityManager.persist(product);
        } catch (Exception e) {
            System.err.println("ko them dc");
        }
    }

    @Override
    public Product getProduct(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }
    @Transactional
    @Override
    public void edit(Product product) {
        List<Product> list = listProduct();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId()==product.getId()){
                list.set(i,product);
                entityManager.merge(product);
            }
        }
    }
    @Transactional
    @Override
    public void delete(int id) {
        List<Product> list = listProduct();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId()== id){
                entityManager.remove(list.get(i));
            }
        }

    }

    @Override
    public Product findName(String name) {
        Product product1 = null;
        for (Product product : listProduct()) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                product1 = product;
            }
        }
        return product1;
    }
}
