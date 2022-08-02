package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.BacklogDto;
import kpfu.ivmiit.project_system.model.Backlog;
import kpfu.ivmiit.project_system.model.Project;
import kpfu.ivmiit.project_system.repository.BacklogRepository;
import kpfu.ivmiit.project_system.repository.ProjectRepository;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacklogServiceImpl implements BacklogService {

    @Autowired
    private BacklogRepository backlogRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Backlog> getAll() {
        return backlogRepository.findAll();
    }

    @Override
    public Backlog add(BacklogDto dto) {
        Project project = projectRepository.findOne(dto.getProject());
        Backlog backlog = Backlog.builder()
                .id(dto.getId())
                .name(dto.getName())
                .techDescription(dto.getTechDescription())
                .status(dto.getStatus())
                .userHistory(dto.getUserHistory())
                .project(project)
                .build();
        return backlogRepository.save(backlog);
    }

    @Override
    public Backlog update(Long id, BacklogDto dto) {
        Project project = projectRepository.findOne(dto.getProject());
        Backlog backlog = backlogRepository.getOne(id);
        backlog.setId(dto.getId());
        backlog.setName(dto.getName());
        backlog.setTechDescription(dto.getTechDescription());
        backlog.setStatus(dto.getStatus());
        backlog.setUserHistory(dto.getUserHistory());
        backlog.setProject(project);
        return backlogRepository.save(backlog);
    }

    @Override
    public void delete(Long id) {
        backlogRepository.delete(id);
    }

    @Override
    public Backlog get(Long id) {
        Backlog result = backlogRepository.getOne(id);

        if (result instanceof HibernateProxy) {
            return (Backlog) ((HibernateProxy)result).getHibernateLazyInitializer().getImplementation();
        }
        return result;
    }
}
