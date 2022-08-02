package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.ProjectDto;
import kpfu.ivmiit.project_system.model.Project;
import kpfu.ivmiit.project_system.model.User;
import kpfu.ivmiit.project_system.repository.ProjectRepository;
import kpfu.ivmiit.project_system.repository.UserRepository;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project add(ProjectDto dto) {
        User user = userRepository.findOne(dto.getWorker());
        Project project = Project.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .isPublic(dto.isPublic())
                .git(dto.getGit())
                .worker(user)
                .build();
        return projectRepository.save(project);
    }

    @Override
    public Project update(Long id, ProjectDto dto) {
        User user = userRepository.findOne(dto.getWorker());
        Project project = projectRepository.findOne(id);
        project.setId(dto.getId());
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setPublic(dto.isPublic());
        project.setGit(dto.getGit());
        project.setWorker(user);
        return projectRepository.save(project);
    }

    @Override
    public void delete(Long id) {
        projectRepository.delete(id);
    }

    @Override
    public Project get(Long id) {
        Project result = projectRepository.getOne(id);

        if (result instanceof HibernateProxy) {
            return (Project) ((HibernateProxy)result).getHibernateLazyInitializer().getImplementation();
        }
        return result;
    }
}
