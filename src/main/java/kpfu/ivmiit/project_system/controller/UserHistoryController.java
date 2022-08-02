package kpfu.ivmiit.project_system.controller;

import kpfu.ivmiit.project_system.dto.UserHistoryDto;
import kpfu.ivmiit.project_system.model.UserHistory;
import kpfu.ivmiit.project_system.service.UserHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project/history")
public class UserHistoryController {
    @Autowired
    private UserHistoryService service;

    @PostMapping
    public ResponseEntity<UserHistory> addObject(@RequestBody UserHistoryDto history) {
        return ResponseEntity.status(201).body(service.add(history));
    }

    @GetMapping
    public ResponseEntity<List<UserHistory>> getObjects() {
        List<UserHistory> histories = service.getAll();
        return ResponseEntity.ok(histories);
    }

    @PutMapping("/{history-id}")
    public ResponseEntity<UserHistory> updateObject(@PathVariable("history-id") Long id, @RequestBody UserHistoryDto history) {
        return ResponseEntity.status(202).body(service.update(id, history));
    }

    @DeleteMapping("/{history-id}")
    public ResponseEntity<Object> deleteObject(@PathVariable("history-id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{history-id}")
    public ResponseEntity<UserHistory> getObject(@PathVariable("history-id") Long id) {
        return ResponseEntity.ok(service.get(id));
    }
}
