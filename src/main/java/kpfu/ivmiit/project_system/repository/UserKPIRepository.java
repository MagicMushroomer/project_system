package kpfu.ivmiit.project_system.repository;

import kpfu.ivmiit.project_system.model.UserKPI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserKPIRepository extends JpaRepository<UserKPI, Long> {
}
