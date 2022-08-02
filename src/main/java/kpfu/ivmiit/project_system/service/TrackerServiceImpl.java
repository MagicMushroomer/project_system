package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.TrackerDto;
import kpfu.ivmiit.project_system.model.Task;
import kpfu.ivmiit.project_system.model.Tracker;
import kpfu.ivmiit.project_system.repository.TaskRepository;
import kpfu.ivmiit.project_system.repository.TrackerRepository;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackerServiceImpl implements TrackerService {

    @Autowired
    private TrackerRepository trackerRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Tracker> getAll() {
        return trackerRepository.findAll();
    }

    @Override
    public Tracker add(TrackerDto dto) {
        Task task = taskRepository.findOne(dto.getTask());
        Tracker tracker = Tracker.builder()
                .id(dto.getId())
                .name(dto.getName())
                .status(dto.getStatus())
                .task(task)
                .build();
        return trackerRepository.save(tracker);
    }

    @Override
    public Tracker update(Long id, TrackerDto dto) {
        Task task = taskRepository.findOne(dto.getTask());
        Tracker tracker = trackerRepository.findOne(id);
        tracker.setId(dto.getId());
        tracker.setName(dto.getName());
        tracker.setStatus(dto.getStatus());
        tracker.setTask(task);
        return trackerRepository.save(tracker);
    }

    @Override
    public void delete(Long id) {
        trackerRepository.delete(id);
    }

    @Override
    public Tracker get(Long id) {
        Tracker result = trackerRepository.getOne(id);

        if (result instanceof HibernateProxy) {
            return (Tracker) ((HibernateProxy)result).getHibernateLazyInitializer().getImplementation();
        }
        return result;
    }
}
