package lt.vu.rest.dto;

import lombok.Getter;
import lombok.Setter;

public class AuthorDto {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String surname;

    @Getter @Setter
    private String website;

    public AuthorDto(Long id, String name, String surname, String website) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.website = website;
    }

    public AuthorDto() {
    }
}

