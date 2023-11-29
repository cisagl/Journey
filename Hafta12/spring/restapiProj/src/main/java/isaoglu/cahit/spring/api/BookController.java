package isaoglu.cahit.spring.api;

import isaoglu.cahit.spring.business.abstracts.IBookService;
import isaoglu.cahit.spring.dto.BookDto;
import isaoglu.cahit.spring.dto.BookDtoConverter;
import isaoglu.cahit.spring.entities.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private BookDtoConverter converter;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public String home(){
        return "Kitap Sayfası";
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findAll(){
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getById(@PathVariable("id") int id){
        Book book = this.bookService.getById(id);
        BookDto bookDto = this.converter.convertDto(book);
        return bookDto;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Book update(@RequestBody Book book){
        Book updateB = this.bookService.getById(book.getId());
        updateB.setName(book.getName());
        updateB.setPublicationYear(book.getPublicationYear());
        updateB.setStock(book.getStock());
        return this.bookService.update(updateB);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        this.bookService.delete(id);
    }

}
