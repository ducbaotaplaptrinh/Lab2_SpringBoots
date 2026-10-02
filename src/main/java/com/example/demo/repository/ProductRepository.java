package com.example.demo.repository;

import com.example.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository cho Entity Product.
 * Kế thừa JpaRepository<Product, Long> để tự động có các phương thức CRUD:
 *   - findAll()       : Lấy tất cả sản phẩm
 *   - findById(id)    : Tìm theo ID
 *   - save(product)   : Thêm mới / Cập nhật
 *   - deleteById(id)  : Xóa theo ID
 *
 * LƯU Ý: Vì field trong Product là "category" (object Category),
 * không phải "categoryId", nên phải dùng dấu gạch dưới (_)
 * để truy cập nested property: Category_Id → category.id
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Tìm kiếm theo tên (chứa keyword, không phân biệt hoa thường)
    List<Product> findByNameContainingIgnoreCase(String keyword);

    // Lọc theo danh mục: dùng Category_Id thay vì CategoryId
    // Spring JPA sẽ dịch thành: WHERE p.category.id = :categoryId
    List<Product> findByCategory_Id(Long categoryId);

    // Lọc theo khoảng giá
    List<Product> findByPriceBetween(Long fromPrice, Long toPrice);

    // Lọc kết hợp: theo danh mục VÀ từ khóa tên
    List<Product> findByCategory_IdAndNameContainingIgnoreCase(Long categoryId, String keyword);

    // Lọc kết hợp: theo danh mục VÀ khoảng giá
    List<Product> findByCategory_IdAndPriceBetween(Long categoryId, Long fromPrice, Long toPrice);
}
