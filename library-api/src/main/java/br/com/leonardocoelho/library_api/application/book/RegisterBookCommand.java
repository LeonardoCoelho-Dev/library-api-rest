package br.com.leonardocoelho.library_api.application.book;

import br.com.leonardocoelho.library_api.domain.book.Genre;

public record RegisterBookCommand(
        String title,
        AuthorCommand author,
        String description,
        PublisherCommand publisher,
        Integer publishedYear,
        String volume,
        Genre genre
) {
}
