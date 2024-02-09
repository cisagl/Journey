package isaoglu.cahit.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrwingDto {
    private String bookName;
    private Integer bookId;
}
