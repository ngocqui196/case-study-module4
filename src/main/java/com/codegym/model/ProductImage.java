package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "images")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Please input name")
    private String nameImage;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public ProductImage() {
    }

    public ProductImage(long id, @NotEmpty(message = "Please input name") String nameImage) {
        this.id = id;
        this.nameImage = nameImage;
    }

    public ProductImage(long id, @NotEmpty(message = "Please input name") String nameImage, Product product) {
        this.id = id;
        this.nameImage = nameImage;
//        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
