package br.com.leonardocoelho.library_api.infra.persistence;

import br.com.leonardocoelho.library_api.domain.book.Book;
import br.com.leonardocoelho.library_api.domain.book.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaBookRepository implements BookRepository {

    private final SpringDataBookRepository jpa;

    public JpaBookRepository(SpringDataBookRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Book save(Book book) {
        return jpa.save(book);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return jpa.findAll(pageable);
    }

    @Override
    public void delete(Book book) {
        jpa.delete(book);
    }
}
