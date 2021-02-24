package com.codegym;

import com.codegym.service.SellerDetailServiceImpl;
import com.codegym.service.seller.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private CustomSuccessHandler customSuccessHandler;

    @Autowired
    private SellerDetailServiceImpl detailService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // Sét đặt dịch vụ để tìm kiếm User trong Database.
        // Và sét đặt PasswordEncoder.

//        auth.userDetailsService(detailService).passwordEncoder(passwordEncoder());
        auth.userDetailsService(sellerService).passwordEncoder(passwordEncoder());

    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}12345").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}12345").roles("ADMIN");
//    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/customer**").access("hasRole('CUSTOMER')")
                .antMatchers("/seller**").access("hasRole('SELLER')")
                .antMatchers("/admin**").access("hasAnyRole('ADMIN','SELLER','CUSTOMER')")
                .and()
                .formLogin()
                .successHandler(customSuccessHandler)
                .loginProcessingUrl("/check_login") // Submit URL
                .loginPage("/login")
                .usernameParameter("seller")
                .passwordParameter("password")
                .defaultSuccessUrl("/seller/seller")
                .failureUrl("/login?error")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
}
