package isaoglu.cahit.spring.api;

import isaoglu.cahit.spring.business.abstracts.IPublisherService;
import isaoglu.cahit.spring.dto.PublisherDto;
import isaoglu.cahit.spring.dto.PublisherDtoConverter;
import isaoglu.cahit.spring.entities.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/publisher")
public class PublisherController {

    @Autowired
    private IPublisherService publisherService;

    @Autowired
    private PublisherDtoConverter converter;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public String home(){
        return "Yayınevi Sayfası";
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Publisher> findAll(){
        return this.publisherService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PublisherDto getById(@PathVariable("id") int id){
        Publisher publisher = this.publisherService.getById(id);
        PublisherDto publisherDto = this.converter.convertDto(publisher);
        return publisherDto;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher save(@RequestBody Publisher publisher){
        return publisherService.save(publisher);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Publisher update(@RequestBody Publisher publisher){
        Publisher updateP = this.publisherService.getById(publisher.getId());
        updateP.setName(publisher.getName());
        updateP.setAddress(publisher.getAddress());
        updateP.setEstablishmentYear(publisher.getEstablishmentYear());
        return this.publisherService.update(updateP);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id){
        this.publisherService.delete(id);
    }
}
