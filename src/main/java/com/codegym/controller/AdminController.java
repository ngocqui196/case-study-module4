package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.admin.product.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CategoryService categoryService;

//    @Autowired
//    private ProductService productService;

//    @GetMapping("/list")
//    public ModelAndView listCategory(@RequestParam("s") Optional<String> keyword, @RequestParam("page") Optional<Integer> page) {
//        Page<Category> categories;
//        ModelAndView modelAndView = new ModelAndView("/admin/category/list");
//        int pageNum = 0;
//        if (page.isPresent() && page.get() > 1) {
//            pageNum = page.get() - 1;
//        }
//        PageRequest pageSplitter = new PageRequest(pageNum, 5, new Sort(Sort.Direction.ASC, "category"));
//        if (keyword.isPresent()) {
//            categories = categoryService.findAllCategoryByName(keyword.get(), pageSplitter);
//            modelAndView.addObject("keyword", keyword.get());
//        } else {
//            categories = categoryService.findAll(pageSplitter);
//        }
//
//        modelAndView.addObject("categories", categories);
//        return modelAndView;
//    }

    @GetMapping("/category/list")
    public ModelAndView listCategory(@RequestParam("s") Optional<String> keyword, @RequestParam("page") Optional<Integer> page) {
        Iterable<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("views/admin/category/list");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/category/create")
    public ModelAndView showCreateFormCategory() {
        return new ModelAndView("views/admin/category/create", "category", new Category());
    }

    @PostMapping("/category/create")
    public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("views/admin/category/create");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "New Category created successfully");
        return modelAndView;
    }

    @GetMapping("/category-edit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id) {
//        Optional<Category> category = categoryService.findById(id);
//        if (category.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("/admin/category/edit");
//            modelAndView.addObject("category", category);
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/admin/error/error.404");
//            return modelAndView;
//        }

        Category category = categoryService.findById(id);
        if (category != null) {
            ModelAndView modelAndView = new ModelAndView("views/admin/category/edit");
            modelAndView.addObject("category", category);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("views/admin/error/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/category-edit")
    public ModelAndView updateProvince(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("views/admin/category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category updated successfully");
        return modelAndView;
    }

    @RequestMapping(value = "/category-delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String removeById(@PathVariable Long id) {
        categoryService.updateById(id);
        return "redirect:admin/category/list";
    }


//    @GetMapping("/product/create")
//    private ModelAndView createNewProduct()

}
