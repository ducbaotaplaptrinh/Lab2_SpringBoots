package com.example.demo.Model;

import jakarta.persistence.*;

/**
 * Entity ánh xạ với bảng "products" trong database WebBanHang.
 * Quan hệ: Nhiều Product thuộc về 1 Category (@ManyToOne).
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Long price;

    @Column(length = 500)
    private String image;

    // Quan hệ Many-to-One: Nhiều sản phẩm thuộc 1 danh mục
    // EAGER: Load thông tin Category ngay khi load Product
    // (tránh LazyInitializationException khi Thymeleaf render product.category.name)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    // Constructor mặc định (bắt buộc với JPA)
    public Product() {}

    public Product(String name, String description, Long price, String image, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.category = category;
    }

    // ========= Getters & Setters =========

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getPrice() { return price; }
    public void setPrice(Long price) { this.price = price; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    // Tiện ích: lấy trực tiếp categoryId từ quan hệ (để tương thích với code cũ)
    public Long getCategoryId() {
        return (category != null) ? category.getId() : null;
    }
}
