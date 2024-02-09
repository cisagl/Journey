package isaoglu.cahit.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherDto {
    private String name;
    private String address;
    private Integer establismentYear;
}
