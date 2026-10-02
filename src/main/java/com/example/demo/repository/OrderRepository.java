package com.example.demo.repository;

import com.example.demo.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository cho Entity Order.
 * Kế thừa JpaRepository<Order, Long> để tự động có các phương thức CRUD:
 *   - findAll()     : Lấy tất cả đơn hàng
 *   - findById(id)  : Tìm theo ID
 *   - save(order)   : Thêm mới / Cập nhật đơn hàng
 *   - deleteById(id): Xóa đơn hàng theo ID
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Tìm đơn hàng theo tên khách hàng (tìm gần đúng, không phân biệt hoa/thường)
    List<Order> findByCustomerNameContainingIgnoreCase(String customerName);
}
