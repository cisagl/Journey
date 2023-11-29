package isaoglu.cahit.spring.business.concretes;

import isaoglu.cahit.spring.business.abstracts.IBookService;
import isaoglu.cahit.spring.dao.BookRepo;
import isaoglu.cahit.spring.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookManager implements IBookService {
    @Autowired
    private BookRepo bookRepo;

    @Override
    public Book getById(int id) {
        return this.bookRepo.findById(id);
    }

    @Override
    public Book save(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public Book update(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public void delete(int id) {
        this.bookRepo.delete(this.getById(id));
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepo.findAll();
    }
}
