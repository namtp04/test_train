package nam.dev.test_training.mapper;

import nam.dev.test_training.dto.request.CategoryRequest;
import nam.dev.test_training.dto.response.CategoryResponse;
import nam.dev.test_training.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryRequest categoryRequest);
    @Mapping(source = "cateName", target = "cateName")
    CategoryResponse toCategoryResponse(Category category);
    void update(@MappingTarget Category category,CategoryRequest categoryRequest);
}
