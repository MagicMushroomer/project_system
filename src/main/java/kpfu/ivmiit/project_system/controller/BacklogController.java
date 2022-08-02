package kpfu.ivmiit.project_system.controller;

import kpfu.ivmiit.project_system.dto.BacklogDto;
import kpfu.ivmiit.project_system.model.Backlog;
import kpfu.ivmiit.project_system.service.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project/backlog")
public class BacklogController {
    @Autowired
    private BacklogService service;

    @PostMapping
    public ResponseEntity<Backlog> addObject(@RequestBody BacklogDto backlog) {
        return ResponseEntity.status(201).body(service.add(backlog));
    }

    @GetMapping
    public ResponseEntity<List<Backlog>> getObjects() {
        List<Backlog> products = service.getAll();
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{backlog-id}")
    public ResponseEntity<Backlog> updateObject(@PathVariable("backlog-id") Long id, @RequestBody BacklogDto backlog) {
        return ResponseEntity.status(202).body(service.update(id, backlog));
    }

    @DeleteMapping("/{backlog-id}")
    public ResponseEntity<Object> deleteObject(@PathVariable("backlog-id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{backlog-id}")
    public ResponseEntity<Backlog> getObject(@PathVariable("backlog-id") Long id) {
        return ResponseEntity.ok(service.get(id));
    }
}
