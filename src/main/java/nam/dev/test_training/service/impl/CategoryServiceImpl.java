package nam.dev.test_training.service.impl;

import lombok.RequiredArgsConstructor;
import nam.dev.test_training.dto.request.CategoryRequest;
import nam.dev.test_training.dto.response.CategoryResponse;
import nam.dev.test_training.entity.Category;
import nam.dev.test_training.exception.AddException;
import nam.dev.test_training.exception.EnumErrorMessage;
import nam.dev.test_training.exception.ErrorCode;
import nam.dev.test_training.mapper.CategoryMapper;
import nam.dev.test_training.repo.CategoryRepo;
import nam.dev.test_training.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryResponse createCategory(CategoryRequest category) {
//        Category category1 = new Category();
        if (categoryRepo.getByCateName(category.getCateName()) != null) {
            throw new AddException(ErrorCode.CATEGORY_EXISTED);
        }
        Category category1 = categoryMapper.toCategory(category);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        category1.setCateName(passwordEncoder.encode(category.getCateName()));
        categoryRepo.save(category1);
        return mapCategoryToCategoryResponse(category1);
    }

    @Override
    public CategoryResponse updateCategory(CategoryRequest category, Long id) {
        Category category1 = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found category"));
//        category1.setCateName(category.getCateName());
        categoryMapper.update(category1, category);
        categoryRepo.save(category1);
        return categoryMapper.toCategoryResponse(category1);
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryRepo.findAll();
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found category"));
        return categoryMapper.toCategoryResponse(category);
    }

    @Override
    public String deleteCategory(Long id) {
        categoryRepo.deleteById(id);
        return "Xóa thành công";
    }

    private CategoryResponse mapCategoryToCategoryResponse(Category category) {
        CategoryResponse category1 = new CategoryResponse();
        category1.setId(category.getId());
        category1.setCateName(category.getCateName());
        return category1;
    }
}
