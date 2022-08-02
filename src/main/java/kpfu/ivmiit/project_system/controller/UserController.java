package kpfu.ivmiit.project_system.controller;

import kpfu.ivmiit.project_system.form.UserForm;
import kpfu.ivmiit.project_system.model.Token;
import kpfu.ivmiit.project_system.model.User;
import kpfu.ivmiit.project_system.service.TokenService;
import kpfu.ivmiit.project_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<User> addObject(@RequestBody UserForm user) {
        return ResponseEntity.status(201).body(service.add(user));
    }

    @GetMapping("/token")
    public ResponseEntity<List<Token>> getTokens() {
        List<Token> tokens = tokenService.getAll();
        return ResponseEntity.ok(tokens);
    }

    @GetMapping
    public ResponseEntity<List<User>> getObjects() {
        List<User> users = service.getAll();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{user-id}")
    public ResponseEntity<User> updateObject(@PathVariable("user-id") Long id, @RequestBody UserForm user) {
        return ResponseEntity.status(202).body(service.update(id, user));
    }

    @DeleteMapping("/{user-id}")
    public ResponseEntity<Object> deleteObject(@PathVariable("user-id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<User> getObject(@PathVariable("user-id") Long id) {
        return ResponseEntity.ok(service.get(id));
    }
}
