package kpfu.ivmiit.project_system.repository;

import kpfu.ivmiit.project_system.model.KPI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KPIRepository extends JpaRepository<KPI, Long> {
}
