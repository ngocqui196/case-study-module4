package com.codegym.service.seller;

import com.codegym.model.Seller;
import com.codegym.model.SellerPrinciple;
import com.codegym.repository.seller.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SellerServiceImpl implements SellerService{

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public Iterable<Seller> findAll() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller save(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public Optional<Seller> findById(Long id) {
        return sellerRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        sellerRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Seller seller = sellerRepository.findBySellerName(username);
      if (seller == null ) {
          throw new UsernameNotFoundException(username);
      }

        return SellerPrinciple.build(seller);
    }

    @Override
    public Seller findBySellerName(String sellerName) {
        return sellerRepository.findBySellerName(sellerName);
    }
}
