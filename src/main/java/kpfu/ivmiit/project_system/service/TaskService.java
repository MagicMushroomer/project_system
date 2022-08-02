package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.TaskDto;
import kpfu.ivmiit.project_system.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll();

    Task add(TaskDto dto);

    Task update(Long id, TaskDto dto);

    void delete(Long id);

    Task get(Long id);
}
