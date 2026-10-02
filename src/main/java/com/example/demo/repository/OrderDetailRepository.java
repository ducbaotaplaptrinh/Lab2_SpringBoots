package com.example.demo.repository;

import com.example.demo.Model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository cho Entity OrderDetail.
 * Kế thừa JpaRepository<OrderDetail, Long> để tự động có các phương thức CRUD:
 *   - findAll()          : Lấy tất cả chi tiết đơn hàng
 *   - findById(id)       : Tìm theo ID
 *   - save(orderDetail)  : Thêm mới / Cập nhật
 *   - deleteById(id)     : Xóa theo ID
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    // Tìm tất cả chi tiết của một đơn hàng theo orderId
    List<OrderDetail> findByOrderId(Long orderId);

    // Tìm tất cả chi tiết có chứa một sản phẩm cụ thể
    List<OrderDetail> findByProductId(Long productId);
}
