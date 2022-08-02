package kpfu.ivmiit.project_system.controller;

import kpfu.ivmiit.project_system.dto.TrackerDto;
import kpfu.ivmiit.project_system.model.Tracker;
import kpfu.ivmiit.project_system.service.TrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project/tracker")
public class TrackerController {
    @Autowired
    private TrackerService service;

    @PostMapping
    public ResponseEntity<Tracker> addObject(@RequestBody TrackerDto tracker) {
        return ResponseEntity.status(201).body(service.add(tracker));
    }

    @GetMapping
    public ResponseEntity<List<Tracker>> getObjects() {
        List<Tracker> trackers = service.getAll();
        return ResponseEntity.ok(trackers);
    }

    @PutMapping()
    public ResponseEntity<Tracker> updateObject(@PathVariable("tracker-id") Long id, @RequestBody TrackerDto tracker) {
        return ResponseEntity.status(202).body(service.update(id, tracker));
    }

    @DeleteMapping("/{tracker-id}")
    public ResponseEntity<Object> deleteObject(@PathVariable("tracker-id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{tracker-id}")
    public ResponseEntity<Tracker> getObject(@PathVariable("tracker-id") Long id) {
        return ResponseEntity.ok(service.get(id));
    }
}
