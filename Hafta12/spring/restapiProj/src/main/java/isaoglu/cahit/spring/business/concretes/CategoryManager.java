package isaoglu.cahit.spring.business.concretes;

import isaoglu.cahit.spring.business.abstracts.ICategoryService;
import isaoglu.cahit.spring.dao.CategoryRepo;
import isaoglu.cahit.spring.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements ICategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category getById(int id) {
        return this.categoryRepo.findById(id);
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category update(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public void delete(int id) {
        this.categoryRepo.delete(this.getById(id));
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepo.findAll();
    }
}
