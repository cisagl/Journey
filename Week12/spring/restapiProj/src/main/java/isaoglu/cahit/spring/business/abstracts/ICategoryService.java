package isaoglu.cahit.spring.business.abstracts;

import isaoglu.cahit.spring.entities.Category;

import java.util.List;

public interface ICategoryService {
    Category getById(int id);
    Category save (Category category);
    Category update (Category category);
    void delete(int id);
    List<Category> findAll();
}
