package isaoglu.cahit.spring.dto;

import isaoglu.cahit.spring.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter {
    public CategoryDto convertDto(Category category){
        return new CategoryDto(
                category.getName(),
                category.getDescription()
        );
    }
}
