package isaoglu.cahit.spring.business.concretes;

import isaoglu.cahit.spring.business.abstracts.IPublisherService;
import isaoglu.cahit.spring.dao.PublisherRepo;
import isaoglu.cahit.spring.entities.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherManager implements IPublisherService {
    @Autowired
    private PublisherRepo publisherRepo;

    @Override
    public Publisher getById(int id) {
        return this.publisherRepo.findById(id);
    }

    @Override
    public Publisher save(Publisher publisher) {
        return this.publisherRepo.save(publisher);
    }

    @Override
    public Publisher update(Publisher publisher) {
        return this.publisherRepo.save(publisher);
    }

    @Override
    public void delete(int id) {
        this.publisherRepo.delete(this.getById(id));
    }

    @Override
    public List<Publisher> findAll() {
        return this.publisherRepo.findAll();
    }
}
