package br.com.leonardocoelho.library_api.interfaces.book;

import br.com.leonardocoelho.library_api.application.book.AuthorCommand;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataAuthor(

        @NotBlank
        String name,

        @NotNull
        @Min(1)
        @Max(200)
        Integer age,

        @NotNull
        @Min(1000)
        @Max(9999)
        Integer birthYear,

        @NotBlank
        String country
) {

    public AuthorCommand toCommand() {
        return new AuthorCommand(name, age, birthYear, country);
    }
}
