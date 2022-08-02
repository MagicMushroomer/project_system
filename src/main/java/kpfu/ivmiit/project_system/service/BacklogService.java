package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.BacklogDto;
import kpfu.ivmiit.project_system.model.Backlog;

import java.util.List;

public interface BacklogService {
    List<Backlog> getAll();

    Backlog add(BacklogDto dto);

    Backlog update(Long id, BacklogDto dto);

    void delete(Long id);

    Backlog get(Long id);
}
