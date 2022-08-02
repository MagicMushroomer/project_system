package kpfu.ivmiit.project_system.repository;

import kpfu.ivmiit.project_system.model.Tracker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackerRepository extends JpaRepository<Tracker, Long> {
}
