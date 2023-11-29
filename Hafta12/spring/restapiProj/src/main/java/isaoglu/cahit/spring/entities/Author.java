package isaoglu.cahit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;

    @Column(name = "author_name", nullable = false, length = 255)
    private String name;

    @Column(name = "author_birthDate")
    private LocalDate birthDate;

    @Column(name = "author_country", length = 255)
    private String country;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Book> bookList;
}