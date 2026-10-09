package com.example.demo.Controller;

import com.example.demo.Model.Category;
import com.example.demo.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 1. Hiển thị danh sách toàn bộ danh mục
     */
    @GetMapping
    public String listCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories/categories-list";
    }

    /**
     * 2. Hiển thị form thêm mới danh mục
     */
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "categories/add-category";
    }

    /**
     * 3. Xử lý lưu danh mục thêm mới
     */
    @PostMapping("/add")
    public String addCategory(@ModelAttribute("category") Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    /**
     * 4. Hiển thị form cập nhật danh mục theo ID
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            return "redirect:/categories";
        }
        model.addAttribute("category", category);
        return "categories/update-category";
    }

    /**
     * 5. Xử lý lưu dữ liệu cập nhật danh mục
     */
    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable("id") Long id, @ModelAttribute("category") Category category) {
        category.setId(id);
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    /**
     * 6. Xóa danh mục theo ID
     */
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/categories";
    }
}
