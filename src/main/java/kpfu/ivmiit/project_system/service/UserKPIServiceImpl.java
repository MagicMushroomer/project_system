package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.UserKPIDto;
import kpfu.ivmiit.project_system.model.UserKPI;
import kpfu.ivmiit.project_system.repository.UserKPIRepository;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserKPIServiceImpl implements UserKPIService {

    @Autowired
    private UserKPIRepository userKPIRepository;

    @Override
    public List<UserKPI> getAll() {
        return userKPIRepository.findAll();
    }

    @Override
    public UserKPI add(UserKPIDto dto) {
        UserKPI userKPI = UserKPI.builder()
                .id(dto.getId())
                .task(dto.getTask())
                .user(dto.getUser())
                .value(dto.getValue())
                .build();
        return userKPIRepository.save(userKPI);
    }

    @Override
    public UserKPI update(Long id, UserKPIDto dto) {
        UserKPI userKPI = userKPIRepository.findOne(id);
        userKPI.setId(dto.getId());
        userKPI.setTask(dto.getTask());
        userKPI.setUser(dto.getUser());
        userKPI.setValue(dto.getValue());
        return userKPIRepository.save(userKPI);
    }

    @Override
    public void delete(Long id) {
        userKPIRepository.delete(id);
    }

    @Override
    public UserKPI get(Long id) {
        UserKPI result = userKPIRepository.getOne(id);

        if (result instanceof HibernateProxy) {
            return (UserKPI) ((HibernateProxy)result).getHibernateLazyInitializer().getImplementation();
        }
        return result;
    }
}
