package kpfu.ivmiit.project_system.repository;

import kpfu.ivmiit.project_system.model.Backlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BacklogRepository extends JpaRepository<Backlog, Long> {
}
