package isaoglu.cahit.spring.business.concretes;

import isaoglu.cahit.spring.business.abstracts.IBookBorrowingService;
import isaoglu.cahit.spring.dao.BookBorrwingRepo;
import isaoglu.cahit.spring.entities.BookBorrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBorrowingManager implements IBookBorrowingService {
    @Autowired
    private BookBorrwingRepo bookBorrwingRepo;
    @Override
    public BookBorrowing getById(int id) {
        return this.bookBorrwingRepo.findById(id);
    }

    @Override
    public BookBorrowing save(BookBorrowing bookBorrowing) {
        return this.bookBorrwingRepo.save(bookBorrowing);
    }

    @Override
    public BookBorrowing update(BookBorrowing bookBorrowing) {
        return this.bookBorrwingRepo.save(bookBorrowing);
    }

    @Override
    public void delete(int id) {
        this.bookBorrwingRepo.delete(this.getById(id));
    }

    @Override
    public List<BookBorrowing> findAll() {
        return this.bookBorrwingRepo.findAll();
    }
}
