import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // Kitaplar Book sınıfı içerisinde isimlerine göre alfabetik olarak sıralandığından ekstra işlem yapılmadı
        TreeSet<Book> books = new TreeSet<>();
        books.add(new Book("The Little Prince", 112, "Antoine de Saint-Exupéry", "1943"));
        books.add(new Book("Harry Potter and the Philosopher's Stone", 223, "J. K. Rowling", "1997"));
        books.add(new Book("A Tale of Two Cities", 448, "Charles Dickens", "1859"));
        books.add(new Book("Crime and Punishment", 704, "Fyodor Dostoevsky", "1866"));
        books.add(new Book("Animal Farm", 140, "George Orwell", "1945"));

        System.out.println("Sort by books name: ");
        for (Book bk : books) {
            System.out.println("\uD83D\uDCD9Book's name: " + bk.getName() + "\t\t \uD83D\uDCDCPage number: " + bk.getPageNumber() + "\t\t ✒\uFE0FAuthor's name: " + bk.getAuthor() + "\t\t \uD83D\uDCC5Publish date: " + bk.getPublishDate());
        }

        System.out.println();
        System.out.println();

        // Kitapları sayfa sayısına göre sıralamak için BookPageNumberComparator adında yeni bir sınıf oluşturuldu
        // .reversed() ile küçükten büyüğe yerine büyükten küçüğe şekline döndürüldü
        TreeSet<Book> booksPN = new TreeSet<>(new BookPageNumberComparator().reversed());
        // Önceki Set'in içerisindeki nesneler direkt olarak kopyalandı
        booksPN.addAll(books);

        System.out.println("Sort by books page number: ");
        for (Book bk : booksPN) {
            System.out.println("\uD83D\uDCD9Book's name: " + bk.getName() + "\t\t \uD83D\uDCDCPage number: " + bk.getPageNumber() + "\t\t ✒\uFE0FAuthor's name: " + bk.getAuthor() + "\t\t \uD83D\uDCC5Publish date: " + bk.getPublishDate());
        }

    }
}