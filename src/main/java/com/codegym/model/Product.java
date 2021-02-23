package com.codegym.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @NotEmpty(message = "Please input type")
    @Size(max = 45)
    private String type;
    @NotNull(message = "Please input descriptionProduct")
    @Size(max = 255)
    private String description;
    @Column(columnDefinition = "integer default 1")
    private int statusProduct;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<ProductImage> productImage;

    public Product() {
    }

    public Product(Long id, @NotEmpty(message = "Please input productName") String productName, @NotEmpty(message = "Please input productPrice") double price, @NotEmpty(message = "Please input productQuantity") int quantity, @NotEmpty(message = "Please input discount") int discount, @NotEmpty(message = "Please input realPrice") double realPrice, @NotEmpty(message = "Please input type") String type, @NotNull(message = "Please input descriptionProduct") String description, @NotEmpty(message = "Please choice status") int statusProduct, Category category) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.realPrice = realPrice;
        this.type = type;
        this.description = description;
        this.statusProduct = statusProduct;
        this.category = category;
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

    public int getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(int statusProduct) {
        this.statusProduct = statusProduct;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<ProductImage> getProductImage() {
        return productImage;
    }

    public void setProductImage(Set<ProductImage> productImage) {
        this.productImage = productImage;
    }
}
