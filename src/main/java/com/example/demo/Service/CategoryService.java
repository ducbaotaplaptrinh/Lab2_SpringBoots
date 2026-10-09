package com.example.demo.Service;

import com.example.demo.Model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service xử lý nghiệp vụ liên quan đến danh mục sản phẩm.
 * Lấy dữ liệu danh mục trực tiếp từ MySQL (Laragon) qua CategoryRepository.
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Lấy toàn bộ danh sách danh mục từ database.
     */
     public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    /**
     * Tìm danh mục theo ID.
     */
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    /**
     * Thêm mới hoặc cập nhật danh mục.
     */
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    /**
     * Xóa danh mục theo ID.
     */
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}

