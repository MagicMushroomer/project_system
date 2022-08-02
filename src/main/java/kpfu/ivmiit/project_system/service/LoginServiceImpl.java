package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.dto.TokenDto;
import kpfu.ivmiit.project_system.form.LoginForm;
import kpfu.ivmiit.project_system.model.Token;
import kpfu.ivmiit.project_system.model.User;
import kpfu.ivmiit.project_system.repository.TokenRepository;
import kpfu.ivmiit.project_system.repository.UserRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static kpfu.ivmiit.project_system.dto.TokenDto.from;

@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public TokenDto login(LoginForm loginForm) {
        Optional<User> userCandidate = userRepository.findUserByLogin(loginForm.getLogin());
        if (userCandidate.isPresent()) {
            User user = userCandidate.get();

            if (passwordEncoder.matches(loginForm.getPassword(), user.getPasswordHash())) {
                Token token = Token.builder()
                        .user(user)
                        .token(RandomStringUtils.random(10, true, true))
                        .build();

                tokenRepository.save(token);
                return from(token, user);
            }
        } throw new IllegalArgumentException("User not found");
    }
}
