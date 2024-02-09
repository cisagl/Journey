package isaoglu.cahit.spring.dto;

import isaoglu.cahit.spring.entities.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorDtoConverter {

    public AuthorDto convertDto(Author author){
        return new AuthorDto(
                author.getName(),
                author.getCountry()
        );
    }
}
