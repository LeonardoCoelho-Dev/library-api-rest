package br.com.leonardocoelho.library_api.publisher;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataPublisher(

        @NotBlank
        String name,

        @NotBlank
        String country,

        @NotNull
        @Min(1000)
        @Max(9999)
        Integer foundationYear
) {
}
