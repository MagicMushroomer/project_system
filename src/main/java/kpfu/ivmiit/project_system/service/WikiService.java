package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.WikiDto;
import kpfu.ivmiit.project_system.model.Wiki;

import java.util.List;

public interface WikiService {
    List<Wiki> getAll();

    Wiki add(WikiDto dto);

    Wiki update(Long id, WikiDto dto);

    void delete(Long id);

    Wiki get(Long id);
}
