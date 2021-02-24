package com.codegym.service;

import com.codegym.model.Category;

import java.util.Optional;

public interface IService<T, I> {

    Iterable<T> findAll();

    Optional<T> findById(I id);

    void save(T model);

    void updateById(I id);

}
