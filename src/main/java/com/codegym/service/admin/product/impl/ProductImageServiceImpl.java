package com.codegym.service.admin.product.impl;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.model.ProductImage;
import com.codegym.repository.admin.ProductImageRepository;
import com.codegym.service.admin.product.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public Iterable<ProductImage> findAll() {
        return productImageRepository.findAll();
    }

    @Override
    public Optional<ProductImage> findById(Long id) {
        return productImageRepository.findById(id);
    }

    @Override
    public void save(ProductImage productImage) {
        productImageRepository.save(productImage);
    }

    @Override
    public Iterable<ProductImage> findProductImageByProduct(Product product) {
        return productImageRepository.findAll();
    }

    @Override
    public void updateById(Long id) {

    }
}
