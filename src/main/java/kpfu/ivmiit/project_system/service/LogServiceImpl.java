package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.LogDto;
import kpfu.ivmiit.project_system.model.Log;
import kpfu.ivmiit.project_system.model.Project;
import kpfu.ivmiit.project_system.repository.LogRepository;
import kpfu.ivmiit.project_system.repository.ProjectRepository;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Log> getAll() {
        return logRepository.findAll();
    }

    @Override
    public Log add(LogDto dto) {
        Project project = projectRepository.findOne(dto.getProject());
        Log log = Log.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .project(project)
                .build();
        return logRepository.save(log);
    }

    @Override
    public Log update(Long id, LogDto dto) {
        Project project = projectRepository.findOne(dto.getProject());
        Log log = logRepository.findOne(id);
        log.setId(dto.getId());
        log.setName(dto.getName());
        log.setDescription(dto.getDescription());
        log.setProject(project);
        return logRepository.save(log);
    }

    @Override
    public void delete(Long id) {
        logRepository.delete(id);
    }

    @Override
    public Log get(Long id) {
        Log result = logRepository.getOne(id);

        if (result instanceof HibernateProxy) {
            return (Log) ((HibernateProxy)result).getHibernateLazyInitializer().getImplementation();
        }
        return result;
    }
}
