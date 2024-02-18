package com.cs5800.dams.adminUser;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 45)
    private String firstName;
    @Column(nullable = false, length = 45)
    private String lastName;
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    @Column(nullable = false, unique = true, length = 15)
    private String password;
    @Column(nullable = false, length = 15)
    private String role;
    @Column(nullable = false, length = 100)
    private String address;
    @Column(nullable = false, length = 45)
    private String city;
    @Column(nullable = false, length = 45)
    private String state;
    @Column(nullable = false, length = 10)
    private Integer zipCode;
    @Column(nullable = false)
    private boolean active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer row) {
        this.id = row;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "row=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                ", active=" + active +
                '}';
    }
}
