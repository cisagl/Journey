package isaoglu.cahit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "publisher")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private int id;

    @Column(name = "publisher_name", length = 255, nullable = false)
    private String name;

    @Column(name = "publisher_establishmentYear")
    private int establishmentYear;

    @Column(name = "publisher_address", length = 255, nullable = false)
    private String address;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Book> bookList;
}
