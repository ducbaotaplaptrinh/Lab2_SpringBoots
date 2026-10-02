package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    // YÊU CẦU 3 & 5: Danh sách sản phẩm kết hợp Lọc và Tìm kiếm
    // Xử lý được cả http://localhost:8080/products VÀ các URL chứa Query Params
    @GetMapping("/products")
    public String products(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Double fromPrice,
            @RequestParam(required = false) Double toPrice,
            Model model) {

        // Gọi Service lọc danh sách từ database
        List<Product> filteredList = productService.filterProducts(categoryId, keyword, fromPrice, toPrice);

        // Truyền danh sách sản phẩm và tham số lọc sang View
        model.addAttribute("products", filteredList);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("keyword", keyword);
        model.addAttribute("fromPrice", fromPrice);
        model.addAttribute("toPrice", toPrice);

        // Truyền danh sách danh mục để render dropdown động từ DB
        model.addAttribute("categories", categoryService.getAllCategories());

        return "web/products"; // Trỏ tới file templates/web/products.html
    }

    // YÊU CẦU 4: Route xem chi tiết sản phẩm theo ID
    @GetMapping("/products/{productId}")
    public String showProductDetail(@PathVariable("productId") Long productId, Model model) {
        Product product = productService.getProductById(productId);

        // Nếu không tìm thấy sản phẩm, chuyển hướng về trang danh sách
        if (product == null) {
            return "redirect:/products";
        }

        model.addAttribute("product", product);
        return "web/product-detail"; // Trỏ tới file templates/web/product-detail.html
    }
}