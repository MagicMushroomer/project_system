package kpfu.ivmiit.project_system.repository;

import kpfu.ivmiit.project_system.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findOneByToken(String token);
}
