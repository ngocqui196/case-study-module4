package com.codegym.repository.seller;

import com.codegym.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Long> {
    Seller getOneByUserName(String username);
}
