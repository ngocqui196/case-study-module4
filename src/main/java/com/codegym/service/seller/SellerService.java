package com.codegym.service.seller;

import com.codegym.model.Seller;
import com.codegym.service.GeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface SellerService extends GeneralService<Seller>, UserDetailsService {
    Seller findByUserName(String username);
}
