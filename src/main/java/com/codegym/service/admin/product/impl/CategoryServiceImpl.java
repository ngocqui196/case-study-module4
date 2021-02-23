package com.codegym.service.admin.product.impl;


import com.codegym.model.Category;
import com.codegym.repository.admin.CategoryRepository;
import com.codegym.service.admin.product.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAllCategory();
    }


    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

//    @Override
//    public Optional<Category> findById(Long id) {
//        return categoryRepository.findById(id);
//    }


//
//    @Override
//    public Page<Category> findAll(Pageable pageable) {
//        return categoryRepository.findAll(pageable);
//    }
//
//    @Override
//    public Page<Category> findAllCategoryByName(String categoryName, Pageable pageable) {
//        return categoryRepository.findAllByCategoryName(categoryName,pageable);
//    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void updateById(Long id) {
        categoryRepository.updateById(id);
    }



//    @Override
//    public void remove(Long id) {
//
//    }
}
