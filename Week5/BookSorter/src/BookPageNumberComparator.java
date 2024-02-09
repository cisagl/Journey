import java.util.Comparator;

public class BookPageNumberComparator implements Comparator<Book> {

    //Kitapları sayfa sayısına göre sıralama metodu
    @Override
    public int compare(Book b1, Book b2) {
        return b1.getPageNumber() - b2.getPageNumber();
    }
}
