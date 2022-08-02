package kpfu.ivmiit.project_system.controller;

import kpfu.ivmiit.project_system.dto.KGIDto;
import kpfu.ivmiit.project_system.model.KGI;
import kpfu.ivmiit.project_system.service.KGIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project/kgi")
public class KGIController {
    @Autowired
    private KGIService service;

    @PostMapping
    public ResponseEntity<KGI> addObject(@RequestBody KGIDto kgi) {
        return ResponseEntity.status(201).body(service.add(kgi));
    }

    @GetMapping
    public ResponseEntity<List<KGI>> getObjects() {
        List<KGI> kgi = service.getAll();
        return ResponseEntity.ok(kgi);
    }

    @PutMapping("/{kgi-id}")
    public ResponseEntity<KGI> updateObject(@PathVariable("kgi-id") Long id, @RequestBody KGIDto kgi) {
        return ResponseEntity.status(202).body(service.update(id, kgi));
    }

    @DeleteMapping("/{kgi-id}")
    public ResponseEntity<Object> deleteObject(@PathVariable("kgi-id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{kgi-id}")
    public ResponseEntity<KGI> getObject(@PathVariable("kgi-id") Long id) {
        return ResponseEntity.ok(service.get(id));
    }
}
