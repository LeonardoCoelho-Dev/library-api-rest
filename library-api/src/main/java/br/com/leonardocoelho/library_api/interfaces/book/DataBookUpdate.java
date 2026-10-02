package br.com.leonardocoelho.library_api.interfaces.book;

import br.com.leonardocoelho.library_api.application.book.UpdateBookCommand;
import br.com.leonardocoelho.library_api.domain.book.Genre;
import jakarta.validation.constraints.NotNull;

public record DataBookUpdate(

        @NotNull
        Long id,

        String title,

        DataAuthor author,

        DataPublisher publisher,

        Genre genre,

        Integer publishedYear,

        String description,

        String volume

) {

    public UpdateBookCommand toCommand() {
        return new UpdateBookCommand(
                id,
                title,
                author != null ? author.toCommand() : null,
                publisher != null ? publisher.toCommand() : null,
                genre,
                publishedYear,
                description,
                volume
        );
    }
}
