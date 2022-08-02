package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.TaskDto;
import kpfu.ivmiit.project_system.model.Project;
import kpfu.ivmiit.project_system.model.Sprint;
import kpfu.ivmiit.project_system.model.Task;
import kpfu.ivmiit.project_system.repository.ProjectRepository;
import kpfu.ivmiit.project_system.repository.SprintRepository;
import kpfu.ivmiit.project_system.repository.TaskRepository;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private SprintRepository sprintRepository;

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task add(TaskDto dto) {
        Sprint sprint = sprintRepository.findOne(dto.getSprint());
        Project project = projectRepository.findOne(dto.getProject());
        Task task = Task.builder()
                .id(dto.getId())
                .name(dto.getName())
                .theme(dto.getTheme())
                .priority(dto.getPriority())
                .status(dto.getStatus())
                .description(dto.getDescription())
                .timeSpent(dto.getTimeSpent())
                .maxTime(dto.getMaxTime())
                .bug(dto.getBug())
                .strings(dto.getStrings())
                .sprint(sprint)
                .dateOver(dto.getDateOver())
                .worker(dto.getWorker())
                .project(project)
                .build();
        return taskRepository.save(task);
    }

    @Override
    public Task update(Long id, TaskDto dto) {
        Sprint sprint = sprintRepository.findOne(dto.getSprint());
        Project project = projectRepository.findOne(dto.getProject());
        Task task = taskRepository.findOne(id);
        task.setId(dto.getId());
        task.setName(dto.getName());
        task.setTheme(dto.getTheme());
        task.setPriority(dto.getPriority());
        task.setStatus(dto.getStatus());
        task.setDescription(dto.getDescription());
        task.setTimeSpent(dto.getTimeSpent());
        task.setMaxTime(dto.getMaxTime());
        task.setBug(dto.getBug());
        task.setStrings(dto.getStrings());
        task.setSprint(sprint);
        task.setDateOver(dto.getDateOver());
        task.setWorker(dto.getWorker());
        task.setProject(project);
        return taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        taskRepository.delete(id);
    }

    @Override
    public Task get(Long id) {
        Task result = taskRepository.getOne(id);

        if (result instanceof HibernateProxy) {
            return (Task) ((HibernateProxy)result).getHibernateLazyInitializer().getImplementation();
        }
        return result;
    }
}
