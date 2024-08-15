package nam.dev.test_training.service;

import nam.dev.test_training.dto.request.CategoryRequest;
import nam.dev.test_training.dto.response.CategoryResponse;
import nam.dev.test_training.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest category);
    CategoryResponse updateCategory(CategoryRequest category,Long id);
    List<Category> getCategoryList();
    CategoryResponse getCategoryById(Long id);
    String deleteCategory(Long id);
}
