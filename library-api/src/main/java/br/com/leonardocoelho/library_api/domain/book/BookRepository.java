package br.com.leonardocoelho.library_api.domain.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Port: the domain states what it needs; the persistence technology lives in infra.
 * (Page/Pageable are kept as a pragmatic concession to avoid reinventing pagination.)
 */
public interface BookRepository {

    Book save(Book book);

    Optional<Book> findById(Long id);

    Page<Book> findAll(Pageable pageable);

    void delete(Book book);
}
