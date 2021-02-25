package com.codegym.repository.admin;

import com.codegym.model.Product;
import com.codegym.model.ProductImage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductImageRepository extends CrudRepository<ProductImage, Long> {

    @Query(value = "select * from images", nativeQuery = true)
    Iterable<ProductImage> findAll();
}
