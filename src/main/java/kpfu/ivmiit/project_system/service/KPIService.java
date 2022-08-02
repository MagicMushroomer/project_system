package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.KPIDto;
import kpfu.ivmiit.project_system.model.KPI;

import java.util.List;

public interface KPIService {
    List<KPI> getAll();

    KPI add(KPIDto dto);

    KPI update(Long id, KPIDto dto);

    void delete(Long id);

    KPI get(Long id);
}
