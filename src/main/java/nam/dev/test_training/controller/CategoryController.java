package nam.dev.test_training.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nam.dev.test_training.dto.request.CategoryRequest;
import nam.dev.test_training.dto.response.ApiResponse;
import nam.dev.test_training.dto.response.CategoryResponse;
import nam.dev.test_training.entity.Category;
import nam.dev.test_training.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategory() {
        return categoryService.getCategoryList();
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public ApiResponse<CategoryResponse> createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        ApiResponse<CategoryResponse> categoryResponse = new ApiResponse<>();
        categoryResponse.setCode(1000);
        categoryResponse.setResult(categoryService.createCategory(categoryRequest));
        return categoryResponse;
    }

    @PutMapping("/{id}")
    public CategoryResponse updateCategory(@PathVariable Long id, @RequestBody CategoryRequest categoryRequest) {
        return categoryService.updateCategory(categoryRequest,id);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        String result = categoryService.deleteCategory(id);
        return result;
    }

}
