package isaoglu.cahit.spring.dto;

import isaoglu.cahit.spring.entities.Publisher;
import org.springframework.stereotype.Component;

@Component
public class PublisherDtoConverter {
    public PublisherDto convertDto(Publisher publisher){
        return new PublisherDto(
                publisher.getName(),
                publisher.getAddress(),
                publisher.getEstablishmentYear()
        );
    }
}
