package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.KGIDto;
import kpfu.ivmiit.project_system.model.KGI;
import kpfu.ivmiit.project_system.model.Project;
import kpfu.ivmiit.project_system.repository.KGIRepository;
import kpfu.ivmiit.project_system.repository.ProjectRepository;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KGIServiceImpl implements KGIService {

    @Autowired
    private KGIRepository kgiRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<KGI> getAll() {
        return kgiRepository.findAll();
    }

    @Override
    public KGI add(KGIDto dto) {
        Project project = projectRepository.findOne(dto.getProject());
        KGI kgi = KGI.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .project(project)
                .build();
        return kgiRepository.save(kgi);
    }

    @Override
    public KGI update(Long id, KGIDto dto) {
        Project project = projectRepository.findOne(dto.getProject());
        KGI kgi = kgiRepository.findOne(id);
        kgi.setId(dto.getId());
        kgi.setDescription(dto.getDescription());
        kgi.setProject(project);
        return kgiRepository.save(kgi);
    }

    @Override
    public void delete(Long id) {
        kgiRepository.delete(id);
    }

    @Override
    public KGI get(Long id) {
        KGI result = kgiRepository.getOne(id);

        if (result instanceof HibernateProxy) {
            return (KGI) ((HibernateProxy)result).getHibernateLazyInitializer().getImplementation();
        }
        return result;
    }
}
