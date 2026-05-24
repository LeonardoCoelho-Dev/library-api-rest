package br.com.leonardocoelho.library_api.book;

import br.com.leonardocoelho.library_api.author.Author;
import br.com.leonardocoelho.library_api.author.DataAuthor;
import br.com.leonardocoelho.library_api.publisher.DataPublisher;
import br.com.leonardocoelho.library_api.publisher.Publisher;
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
}
