package br.com.leonardocoelho.library_api.book;

import br.com.leonardocoelho.library_api.author.DataAuthor;
import br.com.leonardocoelho.library_api.publisher.DataPublisher;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DataBookRegistration(

        @NotBlank
        String title,

        @Valid
        @NotNull
        DataAuthor author,

        @NotBlank
        String description,

        @Valid
        @NotNull
        DataPublisher publisher,

        @NotNull
        @Min(1000)
        @Max(9999)
        Integer publishedYear,

        @NotBlank
        String volume,

        @NotNull
        Genre genre




) {
}
