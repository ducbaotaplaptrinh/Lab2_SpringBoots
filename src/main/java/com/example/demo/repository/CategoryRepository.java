package com.example.demo.repository;

import com.example.demo.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository cho Entity Category.
 * Kế thừa JpaRepository<Category, Long> để tự động có các phương thức CRUD:
 *   - findAll()        : Lấy tất cả danh mục
 *   - findById(id)     : Tìm theo ID
 *   - save(category)   : Thêm mới / Cập nhật
 *   - deleteById(id)   : Xóa theo ID
 *   - count()          : Đếm số danh mục
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // JpaRepository đã tự động cung cấp đầy đủ các phương thức CRUD cơ bản.
    // Không cần viết thêm SQL hay code nào khác.
}
