package kpfu.ivmiit.project_system.service;

import kpfu.ivmiit.project_system.model.Token;
import kpfu.ivmiit.project_system.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public List<Token> getAll() {
        return tokenRepository.findAll();
    }
}
