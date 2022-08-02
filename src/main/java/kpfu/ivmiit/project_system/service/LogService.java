package kpfu.ivmiit.project_system.service;


import kpfu.ivmiit.project_system.dto.LogDto;
import kpfu.ivmiit.project_system.model.Log;

import java.util.List;

public interface LogService {
    List<Log> getAll();

    Log add(LogDto dto);

    Log update(Long id, LogDto dto);

    void delete(Long id);

    Log get(Long id);
}
