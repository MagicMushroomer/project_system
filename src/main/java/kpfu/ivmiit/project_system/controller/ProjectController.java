package kpfu.ivmiit.project_system.controller;

import kpfu.ivmiit.project_system.dto.ProjectDto;
import kpfu.ivmiit.project_system.model.Project;
import kpfu.ivmiit.project_system.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @PostMapping
    public ResponseEntity<Project> addObject(@RequestBody ProjectDto project) {
        return ResponseEntity.status(201).body(service.add(project));
    }

    @GetMapping
    public ResponseEntity<List<Project>> getObjects() {
        List<Project> projects = service.getAll();
        return ResponseEntity.ok(projects);
    }

    @PutMapping("/{project-id}")
    public ResponseEntity<Project> updateObject(@PathVariable("project-id") Long id, @RequestBody ProjectDto project) {
        return ResponseEntity.status(202).body(service.update(id, project));
    }

    @DeleteMapping("/{project-id}")
    public ResponseEntity<Object> deleteObject(@PathVariable("project-id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{project-id}")
    public ResponseEntity<Project> getObject(@PathVariable("project-id") Long id) {
        return ResponseEntity.ok(service.get(id));
    }
}
