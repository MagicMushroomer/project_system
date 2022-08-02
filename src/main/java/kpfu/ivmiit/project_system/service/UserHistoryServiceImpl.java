package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.UserHistoryDto;
import kpfu.ivmiit.project_system.model.Project;
import kpfu.ivmiit.project_system.model.UserHistory;
import kpfu.ivmiit.project_system.repository.ProjectRepository;
import kpfu.ivmiit.project_system.repository.UserHistoryRepository;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserHistoryServiceImpl implements UserHistoryService {

    @Autowired
    private UserHistoryRepository userHistoryRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<UserHistory> getAll() {
        return userHistoryRepository.findAll();
    }

    @Override
    public UserHistory add(UserHistoryDto dto) {
        Project project = projectRepository.findOne(dto.getProject());
        UserHistory history = UserHistory.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .project(project)
                .build();
        return userHistoryRepository.save(history);
    }

    @Override
    public UserHistory update(Long id, UserHistoryDto dto) {
        Project project = projectRepository.findOne(dto.getProject());
        UserHistory history = userHistoryRepository.findOne(id);
        history.setId(dto.getId());
        history.setName(dto.getName());
        history.setDescription(dto.getDescription());
        history.setProject(project);
        return userHistoryRepository.save(history);
    }

    @Override
    public void delete(Long id) {
        userHistoryRepository.delete(id);
    }

    @Override
    public UserHistory get(Long id) {
        UserHistory result = userHistoryRepository.getOne(id);

        if (result instanceof HibernateProxy) {
            return (UserHistory) ((HibernateProxy)result).getHibernateLazyInitializer().getImplementation();
        }
        return result;
    }
}
