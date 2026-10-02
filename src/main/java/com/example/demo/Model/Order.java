package com.example.demo.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Entity ánh xạ với bảng "orders" trong database WebBanHang.
 * Quan hệ: 1 Order có Nhiều OrderDetail (@OneToMany).
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false, length = 150)
    private String customerName;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "total_price", nullable = false)
    private Long totalPrice;

    // Quan hệ 1 Đơn hàng có Nhiều chi tiết đơn hàng
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;

    // Constructor mặc định (bắt buộc với JPA)
    public Order() {}

    public Order(String customerName, LocalDateTime orderDate, Long totalPrice) {
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }

    // ========= Getters & Setters =========

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

    public Long getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Long totalPrice) { this.totalPrice = totalPrice; }

    public List<OrderDetail> getOrderDetails() { return orderDetails; }
    public void setOrderDetails(List<OrderDetail> orderDetails) { this.orderDetails = orderDetails; }
}
