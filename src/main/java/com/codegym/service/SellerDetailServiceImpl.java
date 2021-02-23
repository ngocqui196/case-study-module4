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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Seller seller = sellerRepository.getOneByUserName(username);

        if (username == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<Role> roles = seller.getRoles();
        for (Role role: roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        UserDetails userDetails = new User(seller.getUserName(), seller.getPassword(),grantedAuthorities);
        return userDetails;
    }
}
