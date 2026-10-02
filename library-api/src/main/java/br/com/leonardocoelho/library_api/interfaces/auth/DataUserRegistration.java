package br.com.leonardocoelho.library_api.interfaces.auth;

import br.com.leonardocoelho.library_api.application.user.RegisterUserCommand;
import br.com.leonardocoelho.library_api.domain.user.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataUserRegistration(

        @NotBlank
        String username,

        @NotBlank
        String password,

        @NotNull
        UserRole role

) {

    public RegisterUserCommand toCommand() {
        return new RegisterUserCommand(username, password, role);
    }
}
