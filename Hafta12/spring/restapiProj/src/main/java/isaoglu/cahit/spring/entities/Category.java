package isaoglu.cahit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @Column(name = "category_name", length = 255, nullable = false)
    private String name;

    @Column(name = "category_description", length = 255)
    private String description;

    @ManyToMany(mappedBy = "categoryList")
    @JsonIgnore
    private List<Book> bookList;
}
