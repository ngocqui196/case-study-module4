package com.codegym.service.admin.product;



import com.codegym.model.Category;

import java.util.Optional;

public interface CategoryService {

    Iterable<Category> findAll();

//    Page<Category> findAll(Pageable pageable);
//
//    Page<Category> findAllCategoryByName(String categoryName, Pageable pageable);
//
    Category findById(int id);

    void save(Category category);

    void updateById(Long id);
}
