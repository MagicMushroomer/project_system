package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.UserKPIDto;
import kpfu.ivmiit.project_system.model.UserKPI;

import java.util.List;

public interface UserKPIService {
    List<UserKPI> getAll();

    UserKPI add(UserKPIDto dto);

    UserKPI update(Long id, UserKPIDto dto);

    void delete(Long id);

    UserKPI get(Long id);
}
