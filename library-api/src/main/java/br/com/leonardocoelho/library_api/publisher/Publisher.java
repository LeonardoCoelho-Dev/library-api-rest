package br.com.leonardocoelho.library_api.publisher;

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
public class Publisher {

    private String name;
    private String country;
    private Integer foundationYear;

    public Publisher(DataPublisher data) {
        this.name = data.name();
        this.country = data.country();
        this.foundationYear = data.foundationYear();
    }

    public void updateInformation(DataPublisher data) {
        if (data.name() != null){
            this.name = data.name();
        }
        if (data.country() != null){
            this.country = data.country();
        }
        if (data.foundationYear() != null){
            this.foundationYear = data.foundationYear();
        }
    }
}
