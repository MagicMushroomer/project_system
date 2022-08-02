package kpfu.ivmiit.project_system.repository;

import kpfu.ivmiit.project_system.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {
}
