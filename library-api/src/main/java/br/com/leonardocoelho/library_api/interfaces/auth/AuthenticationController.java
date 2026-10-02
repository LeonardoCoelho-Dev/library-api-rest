package br.com.leonardocoelho.library_api.interfaces.auth;

import br.com.leonardocoelho.library_api.application.user.UserService;
import br.com.leonardocoelho.library_api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserService userService;

    public AuthenticationController(AuthenticationManager authenticationManager,
                                    TokenService tokenService,
                                    UserService userService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<DataTokenJWT> login(@RequestBody @Valid DataAuthentication data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok(new DataTokenJWT(tokenService.generateToken(auth.getName())));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid DataUserRegistration data) {
        userService.register(data.toCommand());
        return ResponseEntity.ok().build();
    }
}
