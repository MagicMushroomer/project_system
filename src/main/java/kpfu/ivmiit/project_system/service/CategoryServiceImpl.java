package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.CategoryDto;
import kpfu.ivmiit.project_system.model.Category;
import kpfu.ivmiit.project_system.model.User;
import kpfu.ivmiit.project_system.repository.CategoryRepository;
import kpfu.ivmiit.project_system.repository.UserRepository;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category add(CategoryDto dto) {
        User user = userRepository.findOne(dto.getWorker());
        Category category = Category.builder()
                .id(dto.getId())
                .type(dto.getType())
                .worker(user)
                .build();
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long id, CategoryDto dto) {
        User user = userRepository.findOne(dto.getWorker());
        Category category = categoryRepository.findOne(id);
        category.setId(dto.getId());
        category.setType(dto.getType());
        category.setWorker(user);
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.delete(id);
    }

    @Override
    public Category get(Long id) {
        Category result = categoryRepository.getOne(id);

        if (result instanceof HibernateProxy) {
            return (Category) ((HibernateProxy)result).getHibernateLazyInitializer().getImplementation();
        }
        return result;
    }
}
