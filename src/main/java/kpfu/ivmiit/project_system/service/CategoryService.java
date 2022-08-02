package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.CategoryDto;
import kpfu.ivmiit.project_system.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();

    Category add(CategoryDto dto);

    Category update(Long id, CategoryDto dto);

    void delete(Long id);

    Category get(Long id);
}
