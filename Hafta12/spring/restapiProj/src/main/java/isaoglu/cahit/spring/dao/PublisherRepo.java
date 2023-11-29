package isaoglu.cahit.spring.dao;

import isaoglu.cahit.spring.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Integer> {
    Publisher findById(int id);
}
