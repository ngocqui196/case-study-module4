package com.codegym.repository.seller;

import com.codegym.model.Seller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends CrudRepository<Seller,Long> {
    Seller findByUserName(String username);
}
