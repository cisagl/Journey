package isaoglu.cahit.spring.api;

import isaoglu.cahit.spring.business.abstracts.IBookBorrowingService;
import isaoglu.cahit.spring.dto.BookBorrwingDto;
import isaoglu.cahit.spring.dto.BookBorrwingDtoConverter;
import isaoglu.cahit.spring.entities.BookBorrowing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/book-borrowing")
public class BookBorrowingController {

    @Autowired
    private IBookBorrowingService bookBorrowingService;
    @Autowired
    private BookBorrwingDtoConverter converter;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public String home(){
        return "Ödünç Kitap Sayfası";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<BookBorrowing> findAll(){
        return this.bookBorrowingService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookBorrwingDto getById(@PathVariable("id") int id){
        BookBorrowing bookBorrowing = this.bookBorrowingService.getById(id);
        BookBorrwingDto bookBorrwingDto = this.converter.converDto(bookBorrowing);
        return bookBorrwingDto;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public BookBorrowing save(@RequestBody BookBorrowing bookBorrowing){
        return bookBorrowingService.save(bookBorrowing);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public BookBorrowing update(@RequestBody BookBorrowing bookBorrowing){
        BookBorrowing updateB = this.bookBorrowingService.getById(bookBorrowing.getId());
        updateB.setBorrowerName(bookBorrowing.getBorrowerName());
        updateB.setId(bookBorrowing.getId());
        return this.bookBorrowingService.update(updateB);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        this.bookBorrowingService.delete(id);
    }

}
