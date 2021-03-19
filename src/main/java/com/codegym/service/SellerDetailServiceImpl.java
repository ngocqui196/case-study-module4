package com.codegym.service;

import com.codegym.model.Role;
import com.codegym.model.Seller;
import com.codegym.repository.seller.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SellerDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SellerRepository sellerRepository;

    public Seller findSellerByUserName(String sellername) {
        return sellerRepository.findBySellerName(sellername);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username ");
        System.out.println(username );
        Seller seller = sellerRepository.findBySellerName(username);
        System.out.println(seller.toString());

        if (username == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        Set<Role> roles = seller.getRoles();
        for (Role role: roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        UserDetails userDetails = (UserDetails) new User(seller.getSellerName(), seller.getPassword(),grantedAuthorities);
        return userDetails;
    }
}
