package kpfu.ivmiit.project_system.repository;

import kpfu.ivmiit.project_system.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
