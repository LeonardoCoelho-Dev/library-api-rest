package br.com.leonardocoelho.library_api.domain.author;

import br.com.leonardocoelho.library_api.domain.shared.DomainException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AuthorTest {

    @Test
    void authorsWithSameValuesAreEqual() {
        var a = new Author("George Orwell", 46, 1903, "UK");
        var b = new Author("George Orwell", 46, 1903, "UK");

        assertThat(a).isEqualTo(b).hasSameHashCodeAs(b);
    }

    @Test
    void rejectsInvalidAge() {
        assertThatThrownBy(() -> new Author("X", 0, 1903, "UK"))
                .isInstanceOf(DomainException.class)
                .hasMessageContaining("age");
        assertThatThrownBy(() -> new Author("X", 201, 1903, "UK"))
                .isInstanceOf(DomainException.class);
    }

    @Test
    void rejectsBlankName() {
        assertThatThrownBy(() -> new Author(" ", 46, 1903, "UK"))
                .isInstanceOf(DomainException.class)
                .hasMessageContaining("name");
    }

    @Test
    void withChangesReturnsNewInstanceAndLeavesOriginalUntouched() {
        var original = new Author("George Orwell", 46, 1903, "UK");

        var changed = original.withChanges(null, null, null, "England");

        assertThat(changed.getCountry()).isEqualTo("England");
        assertThat(changed.getName()).isEqualTo("George Orwell");
        assertThat(original.getCountry()).isEqualTo("UK");
    }
}
