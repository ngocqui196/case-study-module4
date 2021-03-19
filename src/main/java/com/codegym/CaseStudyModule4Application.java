package com.codegym;

import com.codegym.model.Role;
import com.codegym.model.Seller;
import com.codegym.service.role.RoleSevice;
import com.codegym.service.role.RoleSeviceImpl;
import com.codegym.service.seller.SellerService;
import com.codegym.service.seller.SellerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;


import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void init() {
        List<Role> roles = (List<Role>) roleSevice.findAll();
        if (roles.isEmpty()) {
            Role roleAdmin = new Role();
//            roleAdmin.setId(1L);
            roleAdmin.setName("ROLE_ADMIN");
            roleSevice.save(roleAdmin);

            Role roleSeller = new Role();
//            roleSeller.setId(2L);
            roleSeller.setName("ROLE_SELLER");
            roleSevice.save(roleSeller);
        }

        List<Seller> sellers = (List<Seller>) sellerService.findAll();
        if (sellers.isEmpty()) {
            Seller seller1 = new Seller();
//            seller1.setId(1L);
            seller1.setSellerName("seller");
            seller1.setPassword(passwordEncoder.encode("123456"));
            Role role = new Role();
            role.setId(2L);
            Set<Role> roles1 = new HashSet<>();
            roles1.add(role);
            seller1.setRoles(roles1);
            sellerService.save(seller1);

            Seller seller2 = new Seller();
//            seller2.setId(2L);
            seller2.setSellerName("vinh");
            seller2.setPassword(passwordEncoder.encode("123456"));
            Role role2 = new Role();
            role2.setId(2L);
            Set<Role> roles2 = new HashSet<>();
            roles2.add(role2);
            seller2.setRoles(roles2);
            sellerService.save(seller2);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(CaseStudyModule4Application.class, args);
    }

    @Bean
    public SellerService sellerService() {
    return new SellerServiceImpl();
    }

    @Bean
    public RoleSevice roleSevice() {
        return new RoleSeviceImpl();
    }
}
