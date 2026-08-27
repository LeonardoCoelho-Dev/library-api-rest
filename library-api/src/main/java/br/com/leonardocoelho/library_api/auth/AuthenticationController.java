package br.com.leonardocoelho.library_api.auth;

import br.com.leonardocoelho.library_api.infra.security.TokenService;
import br.com.leonardocoelho.library_api.domain.user.DataUserRegistration;
import br.com.leonardocoelho.library_api.domain.user.User;
import br.com.leonardocoelho.library_api.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<DataTokenJWT> login(@RequestBody @Valid DataAuthentication data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new DataTokenJWT(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid DataUserRegistration data) {
        if (userRepository.findByUsername(data.username()) != null) {
            return ResponseEntity.badRequest().build();
        }
        var encryptedPassword = passwordEncoder.encode(data.password());
        var user = new User(data.username(), encryptedPassword, data.role());
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }
}
