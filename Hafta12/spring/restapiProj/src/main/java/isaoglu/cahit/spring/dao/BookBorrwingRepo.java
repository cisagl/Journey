package isaoglu.cahit.spring.dao;

import isaoglu.cahit.spring.entities.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBorrwingRepo extends JpaRepository<BookBorrowing, Integer> {
    BookBorrowing findById(int id);
}
