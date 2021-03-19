package com.codegym.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sellerName;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "seller_role",
            joinColumns = @JoinColumn(name = "seller_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();


    public Seller() {
    }

    public Seller(String sellerName, String password) {
        this.sellerName = sellerName;
        this.password = password;
    }

    public Seller(Long id, String sellerName, String password, Set<Role> roles) {
        this.id = id;
        this.sellerName = sellerName;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
