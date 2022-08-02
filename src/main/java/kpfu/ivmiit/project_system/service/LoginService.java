package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.TokenDto;
import kpfu.ivmiit.project_system.form.LoginForm;

public interface LoginService {
    TokenDto login(LoginForm loginForm);
}
