package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.KPIDto;
import kpfu.ivmiit.project_system.model.KGI;
import kpfu.ivmiit.project_system.model.KPI;
import kpfu.ivmiit.project_system.repository.KGIRepository;
import kpfu.ivmiit.project_system.repository.KPIRepository;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KPIServiceImpl implements KPIService {

    @Autowired
    private KPIRepository kpiRepository;
    @Autowired
    private KGIRepository kgiRepository;

    @Override
    public List<KPI> getAll() {
        return kpiRepository.findAll();
    }

    @Override
    public KPI add(KPIDto dto) {
        KGI kgi = kgiRepository.findOne(dto.getKgi());
        KPI kpi = KPI.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .kgi(kgi)
                .build();
        return kpiRepository.save(kpi);
    }

    @Override
    public KPI update(Long id, KPIDto dto) {
        KGI kgi = kgiRepository.findOne(dto.getKgi());
        KPI kpi = kpiRepository.findOne(id);
        kpi.setId(dto.getId());
        kpi.setDescription(dto.getDescription());
        kpi.setKgi(kgi);
        return kpiRepository.save(kpi);
    }

    @Override
    public void delete(Long id) {
        kpiRepository.delete(id);
    }

    @Override
    public KPI get(Long id) {
        KPI result = kpiRepository.getOne(id);

        if (result instanceof HibernateProxy) {
            return (KPI) ((HibernateProxy)result).getHibernateLazyInitializer().getImplementation();
        }
        return result;
    }
}
