package br.com.leonardocoelho.library_api.domain.user;

import br.com.leonardocoelho.library_api.domain.shared.Guard;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Aggregate root. Knows nothing about Spring Security: the adapter that turns it into
 * a UserDetails lives in infra.security. The password is always an already-encoded hash.
 */
@Entity(name = "User")
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(String username, String encodedPassword, UserRole role) {
        this.username = Guard.notBlank(username, "username");
        this.password = Guard.notBlank(encodedPassword, "password");
        this.role = Guard.notNull(role, "role");
    }
}
