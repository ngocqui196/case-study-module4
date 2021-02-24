package com.codegym.service.admin.category.impl;


import com.codegym.model.Category;
import com.codegym.repository.admin.CategoryRepository;
import com.codegym.service.admin.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void updateById(Long id) {
        categoryRepository.updateById(id);
    }

    @Override
    public Page<Category> findAllByCategoryNameContaining(String categoryName, Pageable pageable) {
        return categoryRepository.findAllByCategoryNameContaining(categoryName, pageable);
    }

    @Override
    public Page<Category> findAllCategory(Pageable pageable) {
        return categoryRepository.findAllCategory(pageable);
    }
}
