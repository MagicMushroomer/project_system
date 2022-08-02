package kpfu.ivmiit.project_system.controller;

import kpfu.ivmiit.project_system.dto.WikiDto;
import kpfu.ivmiit.project_system.model.Wiki;
import kpfu.ivmiit.project_system.service.WikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project/wiki")
public class WikiController {
    @Autowired
    private WikiService service;

    @PostMapping
    public ResponseEntity<Wiki> addObject(@RequestBody WikiDto wiki) {
        return ResponseEntity.status(201).body(service.add(wiki));
    }

    @GetMapping
    public ResponseEntity<List<Wiki>> getObjects() {
        List<Wiki> wikiList = service.getAll();
        return ResponseEntity.ok(wikiList);
    }

    @PutMapping("/{wiki-id}")
    public ResponseEntity<Wiki> updateObject(@PathVariable("wiki-id") Long id, @RequestBody WikiDto wiki) {
        return ResponseEntity.status(202).body(service.update(id, wiki));
    }

    @DeleteMapping("/{wiki-id}")
    public ResponseEntity<Object> deleteObject(@PathVariable("wiki-id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{wiki-id}")
    public ResponseEntity<Wiki> getObject(@PathVariable("wiki-id") Long id) {
        return ResponseEntity.ok(service.get(id));
    }
}
