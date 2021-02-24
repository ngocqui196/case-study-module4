package com.codegym.model;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ProductFrom implements Serializable {

    private Long id;
    @NotEmpty(message = "Please input productName")
    @Size(max = 45)
    private String productName;
    @NotEmpty(message = "Please input productPrice")
    private double price;
    @NotEmpty(message = "Please input productQuantity")
    private int quantity;
    @NotEmpty(message = "Please input discount")
    private int discount;
    @NotEmpty(message = "Please input realPrice")
    private double realPrice;
    @NotEmpty(message = "Please input descriptionProduct")
    @Size(max = 255)
    private String description;
    @NotEmpty
    private Long category_id;
    @NotEmpty
    private MultipartFile images;
    @Column(columnDefinition = "integer default 1")
    private int statusProduct;

    public ProductFrom() {
    }

    public ProductFrom(Long id, @NotEmpty(message = "Please input productName") @Size(max = 45) String productName, @NotEmpty(message = "Please input productPrice") double price, @NotEmpty(message = "Please input productQuantity") int quantity, @NotEmpty(message = "Please input discount") int discount, @NotEmpty(message = "Please input realPrice") double realPrice, @NotNull(message = "Please input descriptionProduct") @Size(max = 255) String description, @NotEmpty Long category_id, @NotEmpty MultipartFile images, int statusProduct) {
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
