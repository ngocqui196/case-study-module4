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
@Service
public class SellerDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SellerRepository sellerRepository;

    public Seller findSellerByUserName(String userName) {
        return sellerRepository.findByUserName(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        Seller seller = sellerRepository.findByUserName(username);
        System.out.println(seller.toString());

        if (username == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<Role> roles = seller.getRoles();
        for (Role role: roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        UserDetails userDetails = (UserDetails) new User(seller.getUserName(), seller.getPassword(),grantedAuthorities);
        return userDetails;
    }
}
