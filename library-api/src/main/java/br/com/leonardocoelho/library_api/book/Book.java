package br.com.leonardocoelho.library_api.book;


import br.com.leonardocoelho.library_api.author.Author;
import br.com.leonardocoelho.library_api.publisher.Publisher;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Book")
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    public Book(DataBookRegistration data){

        this.title = data.title();
        this.description = data.description();
        this.publishedYear = data.publishedYear();
        this.volume = data.volume();
        this.genre = data.genre();
        this.author = new Author(data.author());
        this.publisher = new Publisher(data.publisher());
    }

    public void updateInformation (DataBookUpdate data){
        if (data.title() != null){
            this.title = data.title();
        }
        if (data.description() != null){
            this.description = data.description();
        }
        if (data.publishedYear() != null){
            this.publishedYear = data.publishedYear();
        }
        if (data.genre() != null){
            this.genre = data.genre();
        }
        if (data.author() != null){
            this.author.updateInformation(data.author());
        }
        if (data.publisher() != null){
            this.publisher.updateInformation(data.publisher());
        }
        if (data.volume() != null){
            this.volume = data.volume();
        }
    }

}
