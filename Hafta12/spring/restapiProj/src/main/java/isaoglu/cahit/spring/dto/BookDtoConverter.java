package isaoglu.cahit.spring.dto;

import isaoglu.cahit.spring.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDtoConverter {

    public BookDto convertDto(Book book){
        return new BookDto(
                book.getName(),
                book.getPageNumber(),
                book.getStock()
        );
    }
}
