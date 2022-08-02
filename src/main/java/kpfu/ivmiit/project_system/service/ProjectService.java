package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.ProjectDto;
import kpfu.ivmiit.project_system.model.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAll();

    Project add(ProjectDto dto);

    Project update(Long id, ProjectDto dto);

    void delete(Long id);

    Project get(Long id);
}
