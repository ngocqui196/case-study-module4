package com.codegym.controller;

import com.codegym.model.*;
import com.codegym.service.admin.category.CategoryService;
import com.codegym.service.admin.product.ProductImageService;
import com.codegym.service.admin.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductImageService productImageService;

    @Value("${upload.path}")
    private String fileUpload;

    @GetMapping("/category/list")
    public ModelAndView listCategory(@RequestParam("s") Optional<String> s, @RequestParam("page") Optional<Integer> page, Pageable pageable) {
        Page<Category> categories;
        ModelAndView modelAndView = new ModelAndView("views/admin/category/list");
        int pageNum = 0;
        if (page.isPresent() && page.get() > 1) {
            pageNum = page.get() - 1;
        }
        Sort sort = Sort.by("categoryName");
        if (s.isPresent()) {
            pageable = PageRequest.of(pageNum, 10);
            categories = categoryService.findAllByCategoryNameContaining(s.get(), pageable);
        } else {
            pageable = PageRequest.of(pageNum, 10);
            categories = categoryService.findAllCategory(pageable);
        }

        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/category/create")
    public ModelAndView showCreateFormCategory() {
        return new ModelAndView("views/admin/category/create", "category", new Category());
    }

    @PostMapping("/category/create")
    public ModelAndView saveCategory(@ModelAttribute("category") @Validated Category category, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("views/admin/category/create");
            return modelAndView;
        }
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("views/admin/category/create");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "New Category created successfully");
        return modelAndView;
    }

    @GetMapping("/category-edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("views/admin/category/edit");
            modelAndView.addObject("category", category);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("views/admin/error/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/category-edit")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("views/admin/category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category updated successfully");
        return modelAndView;
    }

    @PostMapping("/category-delete/{id}")
    public String removeById(@PathVariable Long id) {
        categoryService.updateById(id);
        return "redirect:/admin/category/list";
    }


    @GetMapping("/product/create")
    public ModelAndView showCreateFormProduct(@ModelAttribute("category") Category category) {
        ModelAndView modelAndView = new ModelAndView("views/admin/product/create");
        Iterable<Category> categoryList = categoryService.findAll();
        modelAndView.addObject("categories", categoryList);
        modelAndView.addObject("productForm", new ProductFrom());
        return modelAndView;
    }

    @PostMapping("/product/create")
    public ModelAndView saveProduct(@ModelAttribute("productForm") @Validated ProductFrom productFrom, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("views/admin/product/create");
            Iterable<Category> categoryList = categoryService.findAll();
            modelAndView.addObject("categories", categoryList);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("views/admin/product/create");
        Iterable<Category> categoryList = categoryService.findAll();
        modelAndView.addObject("categories", categoryList);
        Product product = new Product();
        product.setProductName(productFrom.getProductName());
        product.setPrice(productFrom.getPrice());
        product.setQuantity(productFrom.getQuantity());
        product.setDiscount(productFrom.getDiscount());
        product.setRealPrice(productFrom.getRealPrice());
        product.setDescription(productFrom.getDescription());
        product.setStatusProduct(productFrom.getStatusProduct());
        Optional<Category> category = categoryService.findById(productFrom.getCategory_id());
        if (category.isPresent()) {
            Category category1 = category.get();
            product.setCategory(category1);
        } else {
            modelAndView.addObject("message", "Error add Category");
            return modelAndView;
        }

        Path path = Paths.get("images/");
        try (InputStream inputStream = productFrom.getImages().getInputStream()) {
            Files.copy(inputStream, path.resolve(productFrom.getImages().getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            String filename = productFrom.getImages().getOriginalFilename();
        } catch (Exception exception) {
            exception.printStackTrace();
            modelAndView.addObject("error", "Please input " + exception.getMessage());
            return modelAndView;
        }

        productService.save(product);
        ProductImage productImage = new ProductImage();
        productImage.setNameImage(productFrom.getImages().getOriginalFilename());
        productImage.setProduct(product);
        productImageService.save(productImage);

        modelAndView.addObject("product", productFrom);
        modelAndView.addObject("message", "The product created successfully");
        return modelAndView;
    }

    @GetMapping("/product/list")
    public ModelAndView listProduct(@RequestParam("s") Optional<String> s, @RequestParam("page") Optional<Integer> page, Pageable pageable) {
        Page<Product> products;

        ModelAndView modelAndView = new ModelAndView("views/admin/product/list");
        int pageNum = 0;
        if (page.isPresent() && page.get() > 1) {
            pageNum = page.get() - 1;
        }
        Sort sort = Sort.by("productName");
        if (s.isPresent()) {
            pageable = PageRequest.of(pageNum, 10);
            products = productService.findAllByProductNameContaining(s.get(), pageable);

        } else {
            pageable = PageRequest.of(pageNum, 10);
            products = productService.findAllProduct(pageable);
        }
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/product-edit/{id}")
    public ModelAndView showFormEditProduct(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("views/admin/product/update");
            modelAndView.addObject("product", product);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("views/admin/error/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/product-edit")
    public ModelAndView updateProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("views/admin/product/update");
        modelAndView.addObject("product", product);
        modelAndView.addObject("message", "Product updated successfully");
        return modelAndView;
    }

    @GetMapping("/product/view/{id}")
    public ModelAndView viewProduct(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("views/admin/product/view)");
        return modelAndView;
    }
}