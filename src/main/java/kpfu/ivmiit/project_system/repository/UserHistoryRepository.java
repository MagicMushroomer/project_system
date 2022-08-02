package kpfu.ivmiit.project_system.repository;

import kpfu.ivmiit.project_system.model.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
}
