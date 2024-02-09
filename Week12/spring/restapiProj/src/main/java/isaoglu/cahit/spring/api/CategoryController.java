package isaoglu.cahit.spring.api;

import isaoglu.cahit.spring.business.abstracts.ICategoryService;
import isaoglu.cahit.spring.dto.BookDto;
import isaoglu.cahit.spring.dto.CategoryDto;
import isaoglu.cahit.spring.dto.CategoryDtoConverter;
import isaoglu.cahit.spring.entities.Book;
import isaoglu.cahit.spring.entities.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private CategoryDtoConverter converter;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public String home(){
        return "Kategori Sayfası";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Category> findAll(){
        return this.categoryService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDto getById(@PathVariable("id") int id){
        Category category = this.categoryService.getById(id);
        CategoryDto categoryDto = this.converter.convertDto(category);
        return categoryDto;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Category update(@RequestBody Category category){
        Category updateC = this.categoryService.getById(category.getId());
        updateC.setName(category.getName());
        updateC.setDescription(category.getDescription());
        return this.categoryService.update(updateC);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        this.categoryService.delete(id);
    }

}
