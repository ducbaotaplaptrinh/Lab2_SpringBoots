package com.example.demo.Controller;

import com.example.demo.Model.Category;
import com.example.demo.Model.Product;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 1. Hiển thị danh sách sản phẩm (kết hợp Tìm kiếm & Lọc theo Danh mục)
     */
    @GetMapping
    public String listProducts(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Double fromPrice,
            @RequestParam(required = false) Double toPrice,
            Model model) {

        List<Product> products = productService.filterProducts(categoryId, keyword, fromPrice, toPrice);

        model.addAttribute("products", products);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("keyword", keyword);
        model.addAttribute("fromPrice", fromPrice);
        model.addAttribute("toPrice", toPrice);
        model.addAttribute("categories", categoryService.getAllCategories());

        return "products/products-list";
    }

    /**
     * 2. Hiển thị form Thêm mới sản phẩm (nạp danh sách danh mục để chọn dropdown)
     */
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "products/add-product";
    }

    /**
     * 3. Xử lý lưu sản phẩm mới
     */
    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product) {
        if (product.getCategory() != null && product.getCategory().getId() != null) {
            Category category = categoryService.getCategoryById(product.getCategory().getId());
            product.setCategory(category);
        }
        productService.saveProduct(product);
        return "redirect:/products";
    }

    /**
     * 4. Hiển thị form Cập nhật sản phẩm theo ID
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "products/update-product";
    }

    /**
     * 5. Xử lý lưu thông tin cập nhật sản phẩm
     */
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute("product") Product product) {
        product.setId(id);
        if (product.getCategory() != null && product.getCategory().getId() != null) {
            Category category = categoryService.getCategoryById(product.getCategory().getId());
            product.setCategory(category);
        }
        productService.saveProduct(product);
        return "redirect:/products";
    }

    /**
     * 6. Xóa sản phẩm theo ID
     */
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }

    /**
     * 7. Xem chi tiết sản phẩm
     */
    @GetMapping("/detail/{productId}")
    public String showProductDetail(@PathVariable("productId") Long productId, Model model) {
        Product product = productService.getProductById(productId);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("product", product);
        return "web/product-detail";
    }
}