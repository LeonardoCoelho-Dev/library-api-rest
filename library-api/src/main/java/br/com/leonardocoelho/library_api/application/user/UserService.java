package br.com.leonardocoelho.library_api.application.user;

import br.com.leonardocoelho.library_api.domain.shared.DomainException;
import br.com.leonardocoelho.library_api.domain.user.User;
import br.com.leonardocoelho.library_api.domain.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(RegisterUserCommand command) {
        if (repository.existsByUsername(command.username())) {
            throw new DomainException("Username already in use");
        }
        var encodedPassword = passwordEncoder.encode(command.password());
        repository.save(new User(command.username(), encodedPassword, command.role()));
    }
}
