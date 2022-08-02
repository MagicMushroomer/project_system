package kpfu.ivmiit.project_system.controller;

import kpfu.ivmiit.project_system.dto.LogDto;
import kpfu.ivmiit.project_system.model.Log;
import kpfu.ivmiit.project_system.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project/log")
public class LogController {
    @Autowired
    private LogService service;

    @PostMapping
    public ResponseEntity<Log> addObject(@RequestBody LogDto log) {
        return ResponseEntity.status(201).body(service.add(log));
    }

    @GetMapping
    public ResponseEntity<List<Log>> getObjects() {
        List<Log> logs = service.getAll();
        return ResponseEntity.ok(logs);
    }

    @PutMapping("/{log-id}")
    public ResponseEntity<Log> updateObject(@PathVariable("log-id") Long id, @RequestBody LogDto log) {
        return ResponseEntity.status(202).body(service.update(id, log));
    }

    @DeleteMapping("/{log-id}")
    public ResponseEntity<Object> deleteObject(@PathVariable("log-id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{log-id}")
    public ResponseEntity<Log> getObject(@PathVariable("log-id") Long id) {
        return ResponseEntity.ok(service.get(id));
    }
}
