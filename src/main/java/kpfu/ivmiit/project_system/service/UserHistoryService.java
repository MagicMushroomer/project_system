package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.UserHistoryDto;
import kpfu.ivmiit.project_system.model.UserHistory;

import java.util.List;

public interface UserHistoryService {
    List<UserHistory> getAll();

    UserHistory add(UserHistoryDto dto);

    UserHistory update(Long id, UserHistoryDto dto);

    void delete(Long id);

    UserHistory get(Long id);
}
