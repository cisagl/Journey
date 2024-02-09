package isaoglu.cahit.spring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "book_borrowing")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookborrowing_id")
    private int id;

    @Column(name = "bookborrowing_borrowerName", length = 255, nullable = false)
    private String borrowerName;

    @Column(name = "bookborrowing_borrowingDate", nullable = false)
    private LocalDate borrowingDate;

    @Column(name = "bookborrowing_returnDate")
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "bookBorrowing_book_id", referencedColumnName = "book_id")
    private Book book;
}
