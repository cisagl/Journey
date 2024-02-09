package isaoglu.cahit.spring.dao;
import isaoglu.cahit.spring.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    Book findById(int id);
}