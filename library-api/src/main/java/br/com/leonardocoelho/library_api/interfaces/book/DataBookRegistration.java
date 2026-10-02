package br.com.leonardocoelho.library_api.interfaces.book;

import br.com.leonardocoelho.library_api.application.book.RegisterBookCommand;
import br.com.leonardocoelho.library_api.domain.book.Genre;
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

    public RegisterBookCommand toCommand() {
        return new RegisterBookCommand(
                title,
                author.toCommand(),
                description,
                publisher.toCommand(),
                publishedYear,
                volume,
                genre
        );
    }
}
