package com.example.demo.service;


import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
    public Product getProduct(int id);
    public List<Product> getAllProducts();
    public void saveProduct(Product product);
}
