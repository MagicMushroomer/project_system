package kpfu.ivmiit.project_system.controller;

import kpfu.ivmiit.project_system.dto.SprintDto;
import kpfu.ivmiit.project_system.model.Sprint;
import kpfu.ivmiit.project_system.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project/sprint")
public class SprintController {

    @Autowired
    private SprintService service;

    @PostMapping
    public ResponseEntity<Sprint> addObject(@RequestBody SprintDto sprint) {
        return ResponseEntity.status(201).body(service.add(sprint));
    }

    @GetMapping
    public ResponseEntity<List<Sprint>> getObjects() {
        List<Sprint> sprints = service.getAll();
        return ResponseEntity.ok(sprints);
    }

    @PutMapping("/{sprint-id}")
    public ResponseEntity<Sprint> updateObject(@PathVariable("sprint-id") Long id, @RequestBody SprintDto sprint) {
        return ResponseEntity.status(202).body(service.update(id, sprint));
    }

    @DeleteMapping("/{sprint-id}")
    public ResponseEntity<Object> deleteObject(@PathVariable("sprint-id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{sprint-id}")
    public ResponseEntity<Sprint> getObject(@PathVariable("sprint-id") Long id) {
        return ResponseEntity.ok(service.get(id));
    }
}
