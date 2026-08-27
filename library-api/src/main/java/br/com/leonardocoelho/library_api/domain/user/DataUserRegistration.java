package br.com.leonardocoelho.library_api.domain.user;

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
}
