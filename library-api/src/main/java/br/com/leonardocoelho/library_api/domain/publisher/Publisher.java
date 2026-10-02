package br.com.leonardocoelho.library_api.domain.publisher;

import br.com.leonardocoelho.library_api.domain.shared.Guard;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Value Object: immutable and compared by value. To "change" a publisher, build a new one.
 */
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class Publisher {

    private String name;
    private String country;
    private Integer foundationYear;

    public Publisher(String name, String country, Integer foundationYear) {
        this.name = Guard.notBlank(name, "publisher name");
        this.country = Guard.notBlank(country, "publisher country");
        this.foundationYear = Guard.inRange(foundationYear, 1000, 9999, "publisher foundation year");
    }

    /**
     * Returns a new Publisher where every non-null argument replaces the current value.
     */
    public Publisher withChanges(String name, String country, Integer foundationYear) {
        return new Publisher(
                name != null ? name : this.name,
                country != null ? country : this.country,
                foundationYear != null ? foundationYear : this.foundationYear
        );
    }
}
