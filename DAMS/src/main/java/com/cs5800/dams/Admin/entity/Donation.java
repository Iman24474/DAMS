package com.cs5800.dams.Admin.entity;

import jakarta.persistence.*;

@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String username;
    private String email;
    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private String item;
    private int quantity;
    @Column(nullable = false)
    private int zipCode;

    public Donation(int id, String username, String email, String category, String item, int quantity,  int zipCode) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.category = category;
        this.item = item;
        this.quantity = quantity;
        this.zipCode = zipCode;
    }

    public Donation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
