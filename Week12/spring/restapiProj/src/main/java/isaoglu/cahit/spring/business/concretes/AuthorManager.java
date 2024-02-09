package isaoglu.cahit.spring.business.concretes;

import isaoglu.cahit.spring.business.abstracts.IAuthorService;
import isaoglu.cahit.spring.dao.AuthorRepo;
import isaoglu.cahit.spring.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorManager implements IAuthorService {
    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public Author getById(int id) {
        return this.authorRepo.findById(id);
    }

    @Override
    public Author save(Author author) {
        return this.authorRepo.save(author);
    }

    @Override
    public Author update(Author author) {
        return this.authorRepo.save(author);
    }

    @Override
    public void delete(int id) {
        this.authorRepo.delete(this.getById(id));
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepo.findAll();
    }
}
