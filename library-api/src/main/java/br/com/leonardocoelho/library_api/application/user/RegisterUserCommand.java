package br.com.leonardocoelho.library_api.application.user;

import br.com.leonardocoelho.library_api.domain.user.UserRole;

public record RegisterUserCommand(String username, String password, UserRole role) {
}
