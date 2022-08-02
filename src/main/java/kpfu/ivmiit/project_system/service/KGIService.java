package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.KGIDto;
import kpfu.ivmiit.project_system.model.KGI;

import java.util.List;

public interface KGIService {
    List<KGI> getAll();

    KGI add(KGIDto dto);

    KGI update(Long id, KGIDto dto);

    void delete(Long id);

    KGI get(Long id);
}
