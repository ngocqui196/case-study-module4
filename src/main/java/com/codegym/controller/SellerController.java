package com.codegym.controller;

import com.codegym.model.Seller;
import com.codegym.service.SellerDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerDetailServiceImpl sellerDetailService;

    @GetMapping("/page")
    public String homeSeller() {
        return "seller";
    }

    @GetMapping("/search")
    public ModelAndView searchSellerByUserName(@RequestParam(name = "username") String userName) {
        ModelAndView modelAndView = new ModelAndView("test");

        modelAndView.addObject("seller",sellerDetailService.findSellerByUserName(userName));
        return modelAndView;
    }



}
