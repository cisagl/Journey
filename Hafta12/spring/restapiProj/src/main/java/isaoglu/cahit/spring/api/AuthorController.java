package isaoglu.cahit.spring.api;

import isaoglu.cahit.spring.business.abstracts.IAuthorService;
import isaoglu.cahit.spring.dto.AuthorDto;
import isaoglu.cahit.spring.dto.AuthorDtoConverter;
import isaoglu.cahit.spring.entities.Author;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/author")
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @Autowired
    private AuthorDtoConverter converter;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public String home() {
        return "Yazar Sayfası";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> findAll() {
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDto getById(@PathVariable("id") int id) {
        Author author = this.authorService.getById(id);
        AuthorDto authorDto = this.converter.convertDto(author);
        return authorDto;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Author save(@RequestBody Author author) {
        return authorService.save(author);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Author update(@RequestBody Author author) {
        Author updateA = this.authorService.getById(author.getId());
        updateA.setName(author.getName());
        updateA.setCountry(author.getCountry());
        return this.authorService.update(updateA);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        this.authorService.delete(id);
    }
}
