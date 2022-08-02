package kpfu.ivmiit.project_system.controller;

import kpfu.ivmiit.project_system.dto.UserKPIDto;
import kpfu.ivmiit.project_system.model.UserKPI;
import kpfu.ivmiit.project_system.service.UserKPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project/user-kpi")
public class UserKPIController {

    @Autowired
    private UserKPIService userKPIService;

    @PostMapping
    public ResponseEntity<UserKPI> addObject(@RequestBody UserKPIDto kpi) {
        return ResponseEntity.status(201).body(userKPIService.add(kpi));
    }

    @GetMapping
    public ResponseEntity<List<UserKPI>> getObjects() {
        List<UserKPI> kpiList = userKPIService.getAll();
        return ResponseEntity.ok(kpiList);
    }

    @PutMapping("/{kpi-id}")
    public ResponseEntity<UserKPI> updateObject(@PathVariable("kpi-id") Long id, @RequestBody UserKPIDto kpi) {
        return ResponseEntity.status(202).body(userKPIService.update(id, kpi));
    }

    @DeleteMapping("/{kpi-id}")
    public ResponseEntity<Object> deleteObject(@PathVariable("kpi-id") Long id) {
        userKPIService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{kpi-id}")
    public ResponseEntity<UserKPI> getObject(@PathVariable("kpi-id") Long id) {
        return ResponseEntity.ok(userKPIService.get(id));
    }
}
