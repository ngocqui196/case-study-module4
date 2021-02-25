package com.codegym.repository.admin;

import com.codegym.model.Category;
import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

//    @Query(value = "select * from products join categories on products.category_id = categories.id where categories.status_category = 1", nativeQuery = true)


    @Query(value = "select * from products join images on products.id = images.product_id where products.status_product = 1", nativeQuery = true)
    Iterable<Product> findAll();

    @Query(value = "select * from products where status_category = 1 order by id", nativeQuery = true)
    Page<Product> findAllProduct(Pageable pageable);

    @Query(value = "select * from products join images on products.id = images.product_id where products.status_product = 1 and products.id = 1?", nativeQuery = true)
    Optional<Product> findById(Long id);

    Page<Product> findAllByProductNameContaining(String nameCategory, Pageable pageable);

//    @Modifying
//    @Transactional
//    @Query(value = "update products set status_category = 0 where id = ?1", nativeQuery = true)
//    void updateById(Long id);

}
