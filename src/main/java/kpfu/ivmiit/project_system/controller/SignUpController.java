package kpfu.ivmiit.project_system.controller;

import kpfu.ivmiit.project_system.form.UserForm;
import kpfu.ivmiit.project_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signUp")
public class SignUpController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody UserForm userForm) {
        userService.add(userForm);
        return ResponseEntity.ok().build();
    }
}
