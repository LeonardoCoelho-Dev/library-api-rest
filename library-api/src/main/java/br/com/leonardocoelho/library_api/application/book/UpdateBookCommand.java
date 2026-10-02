package br.com.leonardocoelho.library_api.application.book;

import br.com.leonardocoelho.library_api.domain.book.Genre;

/**
 * Partial update: null fields mean "keep the current value".
 */
public record UpdateBookCommand(
        Long id,
        String title,
        AuthorCommand author,
        PublisherCommand publisher,
        Genre genre,
        Integer publishedYear,
        String description,
        String volume
) {
}
