package com.codegym.service.admin.product;


import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.model.ProductFrom;
import com.codegym.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService extends IService<Product, Long> {

    Optional<Product> findById(Long id);

    Page<Product> findAllByProductNameContaining(String s, Pageable pageable);

    Page<Product> findAllProduct(Pageable pageable);

    void save(Product product);

//    void remove(Product productCode);

}
