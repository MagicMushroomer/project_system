package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.SprintDto;
import kpfu.ivmiit.project_system.model.Project;
import kpfu.ivmiit.project_system.model.Sprint;
import kpfu.ivmiit.project_system.repository.ProjectRepository;
import kpfu.ivmiit.project_system.repository.SprintRepository;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintServiceImpl implements SprintService {

    @Autowired
    private SprintRepository sprintRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Sprint> getAll() {
        return sprintRepository.findAll();
    }

    @Override
    public Sprint add(SprintDto dto) {
        Project project = projectRepository.findOne(dto.getProject());
        Sprint sprint = Sprint.builder()
                .id(dto.getId())
                .name(dto.getName())
                .dateStart(dto.getDateStart())
                .dateOver(dto.getDateOver())
                .project(project)
                .build();
        return sprintRepository.save(sprint);
    }

    @Override
    public Sprint update(Long id, SprintDto dto) {
        Project project = projectRepository.findOne(dto.getProject());
        Sprint sprint = sprintRepository.findOne(id);
        sprint.setId(dto.getId());
        sprint.setName(dto.getName());
        sprint.setDateStart(dto.getDateStart());
        sprint.setDateOver(dto.getDateOver());
        sprint.setProject(project);
        return sprintRepository.save(sprint);
    }

    @Override
    public void delete(Long id) {
        sprintRepository.delete(id);
    }

    @Override
    public Sprint get(Long id) {
        Sprint result = sprintRepository.getOne(id);

        if (result instanceof HibernateProxy) {
            return (Sprint) ((HibernateProxy)result).getHibernateLazyInitializer().getImplementation();
        }
        return result;
    }
}
