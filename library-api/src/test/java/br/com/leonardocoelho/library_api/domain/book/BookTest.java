package br.com.leonardocoelho.library_api.domain.book;

import br.com.leonardocoelho.library_api.domain.author.Author;
import br.com.leonardocoelho.library_api.domain.publisher.Publisher;
import br.com.leonardocoelho.library_api.domain.shared.DomainException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Pure domain tests: no Spring context and no database.
 */
class BookTest {

    private Author author() {
        return new Author("Machado de Assis", 69, 1839, "Brasil");
    }

    private Publisher publisher() {
        return new Publisher("Garnier", "Brasil", 1844);
    }

    private Book book() {
        return new Book("Dom Casmurro", author(), "Romance classico", publisher(), 1899, "1", Genre.ROMANCE);
    }

    @Test
    void createsBookWithValidData() {
        var book = book();

        assertThat(book.getTitle()).isEqualTo("Dom Casmurro");
        assertThat(book.getAuthor().getName()).isEqualTo("Machado de Assis");
        assertThat(book.getGenre()).isEqualTo(Genre.ROMANCE);
    }

    @Test
    void rejectsBlankTitle() {
        assertThatThrownBy(() -> new Book("  ", author(), "desc", publisher(), 1899, "1", Genre.ROMANCE))
                .isInstanceOf(DomainException.class)
                .hasMessageContaining("title");
    }

    @Test
    void rejectsPublishedYearOutOfRange() {
        assertThatThrownBy(() -> new Book("Title", author(), "desc", publisher(), 999, "1", Genre.ROMANCE))
                .isInstanceOf(DomainException.class)
                .hasMessageContaining("published year");
    }

    @Test
    void rejectsMissingAuthor() {
        assertThatThrownBy(() -> new Book("Title", null, "desc", publisher(), 1899, "1", Genre.ROMANCE))
                .isInstanceOf(DomainException.class)
                .hasMessageContaining("author");
    }

    @Test
    void partialUpdateKeepsUntouchedFields() {
        var book = book();

        book.updateInformation("Novo titulo", null, null, null, null);

        assertThat(book.getTitle()).isEqualTo("Novo titulo");
        assertThat(book.getDescription()).isEqualTo("Romance classico");
        assertThat(book.getPublishedYear()).isEqualTo(1899);
        assertThat(book.getGenre()).isEqualTo(Genre.ROMANCE);
    }

    @Test
    void updateRejectsBlankTitle() {
        var book = book();

        assertThatThrownBy(() -> book.updateInformation("", null, null, null, null))
                .isInstanceOf(DomainException.class);
        assertThat(book.getTitle()).isEqualTo("Dom Casmurro");
    }

    @Test
    void updatingAuthorReplacesTheValueObjectAndKeepsOtherFields() {
        var book = book();
        var original = book.getAuthor();

        book.updateAuthor("Joaquim Maria", null, null, null);

        assertThat(book.getAuthor()).isNotSameAs(original);
        assertThat(book.getAuthor().getName()).isEqualTo("Joaquim Maria");
        assertThat(book.getAuthor().getCountry()).isEqualTo("Brasil");
        assertThat(original.getName()).isEqualTo("Machado de Assis");
    }
}
