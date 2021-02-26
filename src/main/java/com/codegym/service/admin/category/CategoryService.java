package com.codegym.service.admin.category;


import com.codegym.model.Category;
import com.codegym.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService extends IService<Category, Long> {

    Iterable<Category> findAll();

    Page<Category> findAllCategory(Pageable pageable);

    Optional<Category> findById(Long id);

    void save(Category category);

    void updateById(Long id);

    Page<Category> findAllByCategoryNameContaining(String s, Pageable pageable);

}
