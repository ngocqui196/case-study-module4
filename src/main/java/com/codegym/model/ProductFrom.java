package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductFrom {
    private Long id;
    private String productName;
    private double price;
    private int quantity;
    private int discount;
    private double realPrice;
    private String type;
    private String description;
    private MultipartFile images;
    private int statusProduct;

    public ProductFrom(Long id, String productName, double price, int quantity, int discount, double realPrice, String type, String description, MultipartFile images, int statusProduct) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.realPrice = realPrice;
        this.type = type;
        this.description = description;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
