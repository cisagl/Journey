package isaoglu.cahit.spring.business.abstracts;

import isaoglu.cahit.spring.entities.Book;

import java.util.List;

public interface IBookService {
    Book getById(int id);
    Book save (Book book);
    Book update (Book book);
    void delete(int id);
    List<Book> findAll();
}
