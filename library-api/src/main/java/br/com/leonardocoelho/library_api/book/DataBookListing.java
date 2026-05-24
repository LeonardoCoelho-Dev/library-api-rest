package br.com.leonardocoelho.library_api.book;

import br.com.leonardocoelho.library_api.author.DataAuthor;
import br.com.leonardocoelho.library_api.publisher.DataPublisher;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataBookListing(

        Long id,

        String title,

        String author,

        String publisher,

        Genre genre,

        Integer publishedYear
) {

    public DataBookListing(Book book){
        this(
                book.getId(),
                book.getTitle(),
                book.getAuthor().getName(),
                book.getPublisher().getName(),
                book.getGenre(),
                book.getPublishedYear()
        );
    }
}
