package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.TrackerDto;
import kpfu.ivmiit.project_system.model.Tracker;

import java.util.List;

public interface TrackerService {
    List<Tracker> getAll();

    Tracker add(TrackerDto dto);

    Tracker update(Long id, TrackerDto dto);

    void delete(Long id);

    Tracker get(Long id);
}
