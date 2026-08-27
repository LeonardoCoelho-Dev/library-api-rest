package br.com.leonardocoelho.library_api.auth;

import jakarta.validation.constraints.NotBlank;

public record DataAuthentication(

        @NotBlank
        String username,

        @NotBlank
        String password

) {
}
