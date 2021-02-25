package com.codegym.service.admin.product;

import com.codegym.model.Product;
import com.codegym.model.ProductImage;
import com.codegym.service.IService;

import java.util.Optional;

public interface ProductImageService extends IService<ProductImage, Long> {

    void save(ProductImage productImage);

    Iterable<ProductImage> findProductImageByProduct(Product product);
}
