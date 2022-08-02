package kpfu.ivmiit.project_system.controller;

import kpfu.ivmiit.project_system.dto.KPIDto;
import kpfu.ivmiit.project_system.model.KPI;
import kpfu.ivmiit.project_system.service.KPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project/kpi")
public class KPIController {
    @Autowired
    private KPIService service;

    @PostMapping
    public ResponseEntity<KPI> addObject(@RequestBody KPIDto kpi) {
        return ResponseEntity.status(201).body(service.add(kpi));
    }

    @GetMapping
    public ResponseEntity<List<KPI>> getObjects() {
        List<KPI> kpi = service.getAll();
        return ResponseEntity.ok(kpi);
    }

    @PutMapping("/{kpi-id}")
    public ResponseEntity<KPI> updateObject(@PathVariable("kpi-id") Long id, @RequestBody KPIDto kpi) {
        return ResponseEntity.status(202).body(service.update(id, kpi));
    }

    @DeleteMapping("/{kpi-id}")
    public ResponseEntity<Object> deleteObject(@PathVariable("kpi-id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{kpi-id}")
    public ResponseEntity<KPI> getObject(@PathVariable("kpi-id") Long id) {
        return ResponseEntity.ok(service.get(id));
    }
}
