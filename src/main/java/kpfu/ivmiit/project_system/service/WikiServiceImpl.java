package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.WikiDto;
import kpfu.ivmiit.project_system.model.Project;
import kpfu.ivmiit.project_system.model.Wiki;
import kpfu.ivmiit.project_system.repository.ProjectRepository;
import kpfu.ivmiit.project_system.repository.WikiRepository;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WikiServiceImpl implements WikiService {

    @Autowired
    private WikiRepository wikiRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Wiki> getAll() {
        return wikiRepository.findAll();
    }

    @Override
    public Wiki add(WikiDto dto) {
        Project project = projectRepository.findOne(dto.getProject());
        Wiki wiki = Wiki.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .project(project)
                .build();
        return wikiRepository.save(wiki);
    }

    @Override
    public Wiki update(Long id, WikiDto dto) {
        Project project = projectRepository.findOne(dto.getProject());
        Wiki wiki = wikiRepository.findOne(id);
        wiki.setId(dto.getId());
        wiki.setName(dto.getName());
        wiki.setDescription(dto.getDescription());
        wiki.setProject(project);
        return wikiRepository.save(wiki);
    }

    @Override
    public void delete(Long id) {
        wikiRepository.delete(id);
    }

    @Override
    public Wiki get(Long id) {
        Wiki result = wikiRepository.getOne(id);

        if (result instanceof HibernateProxy) {
            return (Wiki) ((HibernateProxy)result).getHibernateLazyInitializer().getImplementation();
        }
        return result;
    }
}
