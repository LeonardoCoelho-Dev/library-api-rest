package br.com.leonardocoelho.library_api.domain.book;

import br.com.leonardocoelho.library_api.domain.author.DataAuthor;
import br.com.leonardocoelho.library_api.domain.DataPublisher;
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
