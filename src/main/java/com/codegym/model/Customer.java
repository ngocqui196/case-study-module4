package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.PrintWriter;
import java.io.Serializable;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Please input name")
    @Size(max = 45)
    private String name;
    @NotNull(message = "Please input address")
    @Size(max = 45)
    private String address;
    private String avatar;
    @NotNull(message = "Please input phone number")
    @Size(max = 45)
    private String phoneNumber;
    @NotNull(message = "Please input username")
    @Size(max = 45)
    @Column(unique = true)
    private String userName;
    @NotNull(message = "Please input password")
    @Size(max = 45)
    private String password;

    public Customer() {
    }

    public Customer(Long id, @NotNull(message = "Please input name") @Size(max = 45) String name, @NotNull(message = "Please input address") @Size(max = 45) String address, String avatar, @NotNull(message = "Please input phone number") @Size(max = 45) String phoneNumber, @NotNull(message = "Please input username") @Size(max = 45) String userName, @NotNull(message = "Please input password") @Size(max = 45) String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.avatar = avatar;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
