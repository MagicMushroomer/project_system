package kpfu.ivmiit.project_system.controller;

import kpfu.ivmiit.project_system.dto.CategoryDto;
import kpfu.ivmiit.project_system.model.Category;
import kpfu.ivmiit.project_system.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping
    public ResponseEntity<Category> addObject(@RequestBody CategoryDto category) {
        return ResponseEntity.status(201).body(service.add(category));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getObjects() {
        List<Category> categories = service.getAll();
        return ResponseEntity.ok(categories);
    }

    @PutMapping("/{category-id}")
    public ResponseEntity<Category> updateObject(@PathVariable("category-id") Long id, @RequestBody CategoryDto category) {
        return ResponseEntity.status(202).body(service.update(id, category));
    }

    @DeleteMapping("/{category-id}")
    public ResponseEntity<Object> deleteObject(@PathVariable("category-id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{category-id}")
    public ResponseEntity<Category> getObject(@PathVariable("category-id") Long id) {
        return ResponseEntity.ok(service.get(id));
    }
}
