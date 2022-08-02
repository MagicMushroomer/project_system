package kpfu.ivmiit.project_system.repository;

import kpfu.ivmiit.project_system.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
