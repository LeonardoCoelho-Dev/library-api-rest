package br.com.leonardocoelho.library_api.domain.author;

import br.com.leonardocoelho.library_api.domain.shared.Guard;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Value Object: immutable and compared by value. To "change" an author, build a new one.
 */
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Author {

    private String name;
    private Integer age;
    private Integer birthYear;
    private String country;

    public Author(String name, Integer age, Integer birthYear, String country) {
        this.name = Guard.notBlank(name, "author name");
        this.age = Guard.inRange(age, 1, 200, "author age");
        this.birthYear = Guard.inRange(birthYear, 1000, 9999, "author birth year");
        this.country = Guard.notBlank(country, "author country");
    }

    /**
     * Returns a new Author where every non-null argument replaces the current value.
     */
    public Author withChanges(String name, Integer age, Integer birthYear, String country) {
        return new Author(
                name != null ? name : this.name,
                age != null ? age : this.age,
                birthYear != null ? birthYear : this.birthYear,
                country != null ? country : this.country
        );
    }
}
