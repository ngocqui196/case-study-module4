package com.codegym.repository.admin;

import com.codegym.model.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

//    @Query(value = "select * from categories where status_category = 1 order by id", nativeQuery = true)
//    Page<Category> findAllCategory(Pageable pageable);
//
//    @Query(value = "select * from categories where category_name = ?1 and status_category = 1 order by category_name asc", nativeQuery = true)
//    Page<Category> findAllByCategoryName(String nameCategory, Pageable pageable);

    @Query(value = "select * from categories where status_category = 1 order by id", nativeQuery = true)
    Iterable<Category> findAllCategory();

    @Query(value = "select * from categories where status_category = 1 and id = ?1", nativeQuery = true)
    Category findById(int id);

    @Modifying
    @Transactional
    @Query(value = "update categories set status_category = 0 where id = ?1", nativeQuery = true)
    void updateById(Long id);


}