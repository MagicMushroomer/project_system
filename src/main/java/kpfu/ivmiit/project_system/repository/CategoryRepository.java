package kpfu.ivmiit.project_system.repository;

import kpfu.ivmiit.project_system.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
