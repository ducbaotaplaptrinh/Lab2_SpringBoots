package com.example.demo.Model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entity ánh xạ với bảng "categories" trong database WebBanHang.
 * Quan hệ: 1 Category có Nhiều Product (@OneToMany).
 */
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    // Quan hệ 1 Danh mục có Nhiều Sản phẩm
    // mappedBy = "category" trỏ tới field "category" trong class Product
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    // Constructor mặc định (bắt buộc với JPA)
    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    // ========= Getters & Setters =========

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}
