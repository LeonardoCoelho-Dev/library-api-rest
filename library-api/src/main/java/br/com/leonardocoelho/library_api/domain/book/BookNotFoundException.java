package br.com.leonardocoelho.library_api.domain.book;

import br.com.leonardocoelho.library_api.domain.shared.DomainException;

public class BookNotFoundException extends DomainException {

    public BookNotFoundException(Long id) {
        super("Book not found: id=" + id);
    }
}
