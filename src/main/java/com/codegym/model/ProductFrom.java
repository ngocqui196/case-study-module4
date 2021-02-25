package com.codegym.model;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

public class ProductFrom implements Serializable {


    private Long id;
    @NotNull
    @NotEmpty(message = "Please input Product name")
    @Size(min = 5, max = 45)
    private String productName;

    @NotNull(message = "Please input Product price")
    private double price;

    @NotNull(message = "Please input Product quantity")
    private int quantity;

    @NotNull(message = "Please input Product discount")
    private int discount;

    private double realPrice;

    @NotNull
    @NotEmpty(message = "Please input Product description")
    @Size(max = 255)
    private String description;

    private Long category_id;

    @NotNull
    private MultipartFile images;

    private int statusProduct;

    public ProductFrom() {
    }

    public ProductFrom(Long id, @NotNull @NotEmpty(message = "Please input Product name") @Size(min = 5, max = 45) String productName, @NotNull(message = "Please input Product price") double price, @NotNull(message = "Please input Product quantity") int quantity, @NotNull(message = "Please input Product discount") int discount, double realPrice, @NotNull @NotEmpty(message = "Please input Product description") @Size(max = 255) String description, Long category_id,@NotNull MultipartFile images, int statusProduct) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.realPrice = realPrice;
        this.description = description;
        this.category_id = category_id;
        this.images = images;
        this.statusProduct = statusProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(double realPrice) {
        this.realPrice = realPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public MultipartFile getImages() {
        return images;
    }

    public void setImages(MultipartFile images) {
        this.images = images;
    }

    public int getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(int statusProduct) {
        this.statusProduct = statusProduct;
    }
}
