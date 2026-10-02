package com.example.demo.Model;

import jakarta.persistence.*;

/**
 * Entity ánh xạ với bảng "order_details" trong database WebBanHang.
 * Quan hệ:
 *   - Nhiều OrderDetail thuộc về 1 Order     (@ManyToOne)
 *   - Nhiều OrderDetail liên kết với 1 Product (@ManyToOne)
 */
@Entity
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantity;

    @Column(name = "unit_price", nullable = false)
    private Long unitPrice;

    // Quan hệ Many-to-One với Order
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    // Quan hệ Many-to-One với Product
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // Constructor mặc định (bắt buộc với JPA)
    public OrderDetail() {}

    public OrderDetail(int quantity, Long unitPrice, Order order, Product product) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.order = order;
        this.product = product;
    }

    // ========= Getters & Setters =========

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Long getUnitPrice() { return unitPrice; }
    public void setUnitPrice(Long unitPrice) { this.unitPrice = unitPrice; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}
