package kpfu.ivmiit.project_system.repository;

import kpfu.ivmiit.project_system.model.Wiki;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiRepository extends JpaRepository<Wiki, Long> {
}
