package br.com.leonardocoelho.library_api.application.book;

import br.com.leonardocoelho.library_api.domain.author.Author;
import br.com.leonardocoelho.library_api.domain.book.Book;
import br.com.leonardocoelho.library_api.domain.book.BookNotFoundException;
import br.com.leonardocoelho.library_api.domain.book.BookRepository;
import br.com.leonardocoelho.library_api.domain.publisher.Publisher;
import br.com.leonardocoelho.library_api.domain.shared.Guard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Application service: orchestrates use cases and owns the transaction boundary.
 * Business rules stay in the domain objects.
 */
@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Book register(RegisterBookCommand command) {
        var author = Guard.notNull(command.author(), "author");
        var publisher = Guard.notNull(command.publisher(), "publisher");

        var book = new Book(
                command.title(),
                new Author(author.name(), author.age(), author.birthYear(), author.country()),
                command.description(),
                new Publisher(publisher.name(), publisher.country(), publisher.foundationYear()),
                command.publishedYear(),
                command.volume(),
                command.genre()
        );
        return repository.save(book);
    }

    @Transactional(readOnly = true)
    public Page<Book> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional
    public void update(UpdateBookCommand command) {
        var book = findOrFail(command.id());

        book.updateInformation(
                command.title(),
                command.description(),
                command.publishedYear(),
                command.volume(),
                command.genre()
        );
        if (command.author() != null) {
            var author = command.author();
            book.updateAuthor(author.name(), author.age(), author.birthYear(), author.country());
        }
        if (command.publisher() != null) {
            var publisher = command.publisher();
            book.updatePublisher(publisher.name(), publisher.country(), publisher.foundationYear());
        }
    }

    @Transactional
    public void delete(Long id) {
        repository.delete(findOrFail(id));
    }

    private Book findOrFail(Long id) {
        return repository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }
}
