package kpfu.ivmiit.project_system.controller;

import kpfu.ivmiit.project_system.dto.TokenDto;
import kpfu.ivmiit.project_system.form.LoginForm;
import kpfu.ivmiit.project_system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService userService;

    @PostMapping
    public ResponseEntity<TokenDto> login(@RequestBody LoginForm loginForm) {
        return ResponseEntity.ok(userService.login(loginForm));
    }
}
