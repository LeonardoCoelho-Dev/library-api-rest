package br.com.leonardocoelho.library_api.domain.book;

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
