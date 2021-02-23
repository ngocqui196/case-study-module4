package com.codegym.service.admin.product.impl;

import com.codegym.model.Product;
import com.codegym.service.admin.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductService productRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
