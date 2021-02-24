package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "images")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameImage;

    @ManyToOne
    @JoinColumn(name = "product_id", unique = true, nullable = true)
    private Product product;

    public ProductImage() {
    }

    public ProductImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public ProductImage(String nameImage, Product product) {
        this.nameImage = nameImage;
        this.product = product;
    }

    public ProductImage(Long id, String nameImage, Product product) {
        this.id = id;
        this.nameImage = nameImage;
//        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
