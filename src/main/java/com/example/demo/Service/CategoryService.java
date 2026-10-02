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
     * Dùng để render dropdown lọc danh mục trong giao diện.
     */
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
