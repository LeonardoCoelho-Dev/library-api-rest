package br.com.leonardocoelho.library_api.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserRepository extends JpaRepository<User, Long>, UserDetailsService {

    UserDetails findByUsername(String username);

    @Override
    default UserDetails loadUserByUsername(String username) {
        return findByUsername(username);
    }
}
