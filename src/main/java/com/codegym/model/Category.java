package com.codegym.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Please input categoryName")
    private String categoryName;
    @NotEmpty(message = "Please input descriptionCategory")
    @Size(max = 255)
    private String description;
    @Column(columnDefinition = "integer default 1")
    private int statusCategory;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    public Category() {
    }


    public Category(Long id, @NotEmpty(message = "Please input categoryName") String categoryName, @NotEmpty(message = "Please input descriptionCategory") String description, @NotEmpty(message = "Please choice status") int statusCategory, Set<Product> products) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.statusCategory = statusCategory;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getStatus() {
        return statusCategory;
    }

    public void setStatus(int statusProduct) {
        this.statusCategory = statusProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatusCategory() {
        return statusCategory;
    }

    public void setStatusCategory(int statusCategory) {
        this.statusCategory = statusCategory;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
