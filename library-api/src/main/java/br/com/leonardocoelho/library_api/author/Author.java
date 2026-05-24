package br.com.leonardocoelho.library_api.author;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Author {

    private String name;
    private Integer age;
    private Integer birthYear;
    private String country;

    public Author(DataAuthor data) {
        this.name = data.name();
        this.age = data.age();
        this.birthYear = data.birthYear();
        this.country = data.country();
    }

    public void updateInformation(DataAuthor data) {
        if (data.name() != null){
            this.name = data.name();
        }
        if (data.age() != null){
            this.age = data.age();
        }
        if (data.birthYear() != null){
            this.birthYear = data.birthYear();
        }
        if (data.country() != null){
            this.country = data.country();
        }
    }
}
