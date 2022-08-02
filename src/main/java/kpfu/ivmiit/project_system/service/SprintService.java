package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.SprintDto;
import kpfu.ivmiit.project_system.model.Sprint;

import java.util.List;

public interface SprintService {
    List<Sprint> getAll();

    Sprint add(SprintDto dto);

    Sprint update(Long id, SprintDto dto);

    void delete(Long id);

    Sprint get(Long id);
}
