package com.codegym.service.admin.product.impl;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.repository.admin.ProductImageRepository;
import com.codegym.repository.admin.ProductRepository;
import com.codegym.service.admin.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Page<Product> findAllByProductNameContaining(String s, Pageable pageable) {
        return productRepository.findAllByProductNameContaining(s, pageable);
    }


    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateById(Long id) {

    }


}
