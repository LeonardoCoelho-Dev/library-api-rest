package br.com.leonardocoelho.library_api.infra.persistence;

import br.com.leonardocoelho.library_api.domain.user.User;
import br.com.leonardocoelho.library_api.domain.user.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaUserRepository implements UserRepository {

    private final SpringDataUserRepository jpa;

    public JpaUserRepository(SpringDataUserRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public User save(User user) {
        return jpa.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return jpa.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return jpa.existsByUsername(username);
    }
}
