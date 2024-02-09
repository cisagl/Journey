package isaoglu.cahit.spring.business.abstracts;

import isaoglu.cahit.spring.entities.Author;

import java.util.List;

public interface IAuthorService {
    Author getById(int id);
    Author save (Author author);
    Author update (Author author);
    void delete (int id);
    List<Author> findAll();
}
