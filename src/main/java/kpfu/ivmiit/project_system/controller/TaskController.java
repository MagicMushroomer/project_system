package kpfu.ivmiit.project_system.controller;

import kpfu.ivmiit.project_system.dto.TaskDto;
import kpfu.ivmiit.project_system.model.Task;
import kpfu.ivmiit.project_system.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project/task")
public class TaskController {
    @Autowired
    private TaskService service;

    @PostMapping
    public ResponseEntity<Task> addObject(@RequestBody TaskDto task) {
        return ResponseEntity.status(201).body(service.add(task));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getObjects() {
        List<Task> tasks = service.getAll();
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{task-id}")
    public ResponseEntity<Task> updateObject(@PathVariable("task-id") Long id, @RequestBody TaskDto task) {
        return ResponseEntity.status(202).body(service.update(id, task));
    }

    @DeleteMapping("/{task-id}")
    public ResponseEntity<Object> deleteObject(@PathVariable("task-id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{task-id}")
    public ResponseEntity<Task> getObject(@PathVariable("task-id") Long id) {
        return ResponseEntity.ok(service.get(id));
    }
}
