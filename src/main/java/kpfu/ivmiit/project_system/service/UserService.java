package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.form.UserForm;
import kpfu.ivmiit.project_system.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();

    User add(UserForm userForm);

    User update(Long id, UserForm userForm);

    void delete(Long id);

    User get(Long id);

    Optional<User> findUserByLogin(String login);
}
