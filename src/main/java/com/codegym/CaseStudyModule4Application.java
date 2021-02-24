package com.codegym;

import com.codegym.model.Role;
import com.codegym.model.Seller;
import com.codegym.service.role.RoleSevice;
import com.codegym.service.seller.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class CaseStudyModule4Application {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private RoleSevice roleSevice;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @PostConstruct
    public void init() {
        List<Role> roles = (List<Role>) roleSevice.findAll();
        if (roles.isEmpty()) {
            Role roleAdmin = new Role();
            roleAdmin.setId(1L);
            roleAdmin.setRoleName("ADMIN");
            roleSevice.save(roleAdmin);
            Role roleSeller = new Role();
            roleAdmin.setId(2L);
            roleSeller.setRoleName("SELLER");
            roleSevice.save(roleSeller);
        }

        List<Seller> sellers = (List<Seller>) sellerService.findAll();
        if (sellers.isEmpty()) {
            Seller seller1 = new Seller();
            seller1.setName("seller");
            seller1.setAddress("hai phong");
            seller1.setAvatar("sfdgsdfb");
            seller1.setPhoneNumber("0123456789");
            seller1.setUserName("seller");
            seller1.setPassword(passwordEncoder.encode("123456"));
            Role role = new Role();
            role.setId(1L);
            List<Role> roles1 = new ArrayList<>();
            roles1.add(role);
            seller1.setRoles(roles1);
            sellerService.save(seller1);

            Seller seller2 = new Seller();
            seller1.setName("vinh");
            seller1.setAddress("hai phong");
            seller1.setAvatar("sfdgsdfb");
            seller1.setPhoneNumber("0123456789");
            seller1.setUserName("vinh");
            seller1.setPassword(passwordEncoder.encode("123456"));
            Role role2 = new Role();
            role.setId(2L);
            List<Role> roles2 = new ArrayList<>();
            roles2.add(role2);
            seller1.setRoles(roles2);
            sellerService.save(seller2);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(CaseStudyModule4Application.class, args);
    }

}
