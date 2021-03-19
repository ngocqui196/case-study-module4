package com.codegym.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;

        @ManyToMany(mappedBy = "roles")
        private Set<Seller> sellers = new HashSet<>();

        public Role() {
        }

        public Role(String name) {
            this.name = name;
        }

        public Role(Long id, String name) {
            this.id = id;
        this.name = name;
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

        public Set<Seller> getUsers() {
            return sellers;
        }

        public void setUsers(Set<Seller> sellers) {
            this.sellers = sellers;
        }

    }

