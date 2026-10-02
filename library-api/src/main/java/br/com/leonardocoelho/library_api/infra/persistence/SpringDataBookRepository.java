package br.com.leonardocoelho.library_api.infra.persistence;

import br.com.leonardocoelho.library_api.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataBookRepository extends JpaRepository<Book, Long> {
}
