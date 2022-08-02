package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.form.UserForm;
import kpfu.ivmiit.project_system.model.Role;
import kpfu.ivmiit.project_system.model.State;
import kpfu.ivmiit.project_system.model.User;
import kpfu.ivmiit.project_system.model.WorkingRole;
import kpfu.ivmiit.project_system.repository.TokenRepository;
import kpfu.ivmiit.project_system.repository.UserRepository;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User add(UserForm userForm) {
        String hash = passwordEncoder.encode(userForm.getPassword());

        User user = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .login(userForm.getLogin())
                .passwordHash(hash)
                .email(userForm.getEmail())
                .workingRole(WorkingRole.valueOf(userForm.getRole()))
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, UserForm userForm) {
        String hash = passwordEncoder.encode(userForm.getPassword());
        User user = userRepository.getOne(id);
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setLogin(userForm.getLogin());
        user.setPasswordHash(hash);
        user.setEmail(userForm.getEmail());
        user.setWorkingRole(WorkingRole.valueOf(userForm.getRole()));

        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User get(Long id) {
        User result = userRepository.getOne(id);

        if (result instanceof HibernateProxy) {
            return (User) ((HibernateProxy)result).getHibernateLazyInitializer().getImplementation();
        }
        return result;
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        Optional<User> user = userRepository.findUserByLogin(login);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }


}
