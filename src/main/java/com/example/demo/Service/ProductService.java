package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    // Spring Boot tự động inject Repository (Dependency Injection)
    @Autowired
    private ProductRepository productRepository;

    /**
     * Lấy toàn bộ danh sách sản phẩm từ database.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Tìm sản phẩm theo ID.
     * Trả về null nếu không tìm thấy.
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Lọc sản phẩm theo nhiều tiêu chí linh hoạt:
     * - categoryId : Lọc theo danh mục
     * - keyword    : Tìm theo tên sản phẩm
     * - fromPrice  : Giá từ
     * - toPrice    : Giá đến
     *
     * Các tham số có thể null (không bắt buộc phải truyền hết).
     */
    public List<Product> filterProducts(Long categoryId, String keyword, Double fromPrice, Double toPrice) {

        boolean hasCategory = (categoryId != null);
        boolean hasKeyword  = (keyword != null && !keyword.trim().isEmpty());
        boolean hasPrice    = (fromPrice != null && toPrice != null);

        // Lọc kết hợp danh mục + keyword
        if (hasCategory && hasKeyword) {
            return productRepository.findByCategory_IdAndNameContainingIgnoreCase(categoryId, keyword.trim());
        }

        // Lọc kết hợp danh mục + khoảng giá
        if (hasCategory && hasPrice) {
            return productRepository.findByCategory_IdAndPriceBetween(
                    categoryId, fromPrice.longValue(), toPrice.longValue());
        }

        // Chỉ lọc theo danh mục
        if (hasCategory) {
            return productRepository.findByCategory_Id(categoryId);
        }

        // Chỉ tìm theo keyword
        if (hasKeyword) {
            return productRepository.findByNameContainingIgnoreCase(keyword.trim());
        }

        // Chỉ lọc theo khoảng giá
        if (hasPrice) {
            return productRepository.findByPriceBetween(fromPrice.longValue(), toPrice.longValue());
        }

        // Không có bộ lọc nào → lấy hết
        return productRepository.findAll();
    }
}