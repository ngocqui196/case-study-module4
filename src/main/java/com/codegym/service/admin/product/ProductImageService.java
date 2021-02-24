package com.codegym.service.admin.product;

import com.codegym.model.ProductImage;
import com.codegym.service.IService;

public interface ProductImageService extends IService<ProductImage, Long> {

    void save(ProductImage productImage);
}
