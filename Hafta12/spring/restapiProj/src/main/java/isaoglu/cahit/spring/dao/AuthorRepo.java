package isaoglu.cahit.spring.dao;
import isaoglu.cahit.spring.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {
    Author findById(int id);
}