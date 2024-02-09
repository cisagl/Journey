package isaoglu.cahit.spring.business.abstracts;


import isaoglu.cahit.spring.entities.BookBorrowing;

import java.util.List;

public interface IBookBorrowingService {
    BookBorrowing getById(int id);
    BookBorrowing save (BookBorrowing bookBorrowing);
    BookBorrowing update (BookBorrowing bookBorrowing);
    void delete(int id);
    List<BookBorrowing> findAll();
}
