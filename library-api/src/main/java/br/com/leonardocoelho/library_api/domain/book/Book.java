package br.com.leonardocoelho.library_api.domain.book;

import br.com.leonardocoelho.library_api.domain.author.Author;
import br.com.leonardocoelho.library_api.domain.publisher.Publisher;
import br.com.leonardocoelho.library_api.domain.shared.Guard;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Aggregate root. Every state change goes through methods that protect its invariants;
 * there are no public setters.
 */
@Entity(name = "Book")
@Table(name = "books")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "author_name")),
            @AttributeOverride(name = "age", column = @Column(name = "author_age")),
            @AttributeOverride(name = "country", column = @Column(name = "author_country")),
            @AttributeOverride(name = "birthYear", column = @Column(name = "author_birth_year"))
    })
    private Author author;
    private String description;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "publisher_name")),
            @AttributeOverride(name = "country", column = @Column(name = "publisher_country")),
            @AttributeOverride(name = "foundationYear", column = @Column(name = "publisher_foundation_year"))
    })
    private Publisher publisher;
    @Column(name = "published_year")
    private Integer publishedYear;
    private String volume;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Book(String title, Author author, String description, Publisher publisher,
                Integer publishedYear, String volume, Genre genre) {
        this.title = Guard.notBlank(title, "title");
        this.author = Guard.notNull(author, "author");
        this.description = Guard.notBlank(description, "description");
        this.publisher = Guard.notNull(publisher, "publisher");
        this.publishedYear = Guard.inRange(publishedYear, 1000, 9999, "published year");
        this.volume = Guard.notBlank(volume, "volume");
        this.genre = Guard.notNull(genre, "genre");
    }

    /**
     * Partial update: null arguments mean "keep the current value".
     */
    public void updateInformation(String title, String description, Integer publishedYear,
                                  String volume, Genre genre) {
        if (title != null) {
            this.title = Guard.notBlank(title, "title");
        }
        if (description != null) {
            this.description = Guard.notBlank(description, "description");
        }
        if (publishedYear != null) {
            this.publishedYear = Guard.inRange(publishedYear, 1000, 9999, "published year");
        }
        if (volume != null) {
            this.volume = Guard.notBlank(volume, "volume");
        }
        if (genre != null) {
            this.genre = genre;
        }
    }

    public void updateAuthor(String name, Integer age, Integer birthYear, String country) {
        this.author = this.author.withChanges(name, age, birthYear, country);
    }

    public void updatePublisher(String name, String country, Integer foundationYear) {
        this.publisher = this.publisher.withChanges(name, country, foundationYear);
    }
}
