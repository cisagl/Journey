package isaoglu.cahit.spring.dto;

import isaoglu.cahit.spring.entities.BookBorrowing;
import org.springframework.stereotype.Component;

@Component
public class BookBorrwingDtoConverter {
    public BookBorrwingDto converDto(BookBorrowing bookBorrowing){
        return new BookBorrwingDto(
                bookBorrowing.getBorrowerName(),
                bookBorrowing.getId()
        );
    }
}
