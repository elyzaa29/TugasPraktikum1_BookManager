import org.example.Book;
import org.example.BookManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookManagerTest {
    private BookManager bookManager;

    @BeforeEach
    void setup() {
        bookManager = new BookManager();
    }

    @Test
    @DisplayName("Test menambahkan buku")
    void testAddBook() {
        Book book = new Book("Pemrograman", "Andi", 2020);
        bookManager.addBook(book);
        assertEquals(1, bookManager.getBookCount());
    }

    @Test
    @DisplayName("Test menghapus buku yang ada")
    void testRemoveExistingBook() {
        Book book = new Book("Basis Data", "ErLangga", 2021);
        bookManager.addBook(book);

        boolean removed = bookManager.removeBook("Basis Data");
        assertTrue(removed);
        assertEquals(0, bookManager.getBookCount());
    }

    // Lengkapi Unit Test dibawah untuk buku yang memang tidak terdapat pada List
    @Test
    @DisplayName("Test menghapus buku yang tidak ada")
    void testRemoveNonExistingBook() {
        Book book = new Book("Algoritma Machine Learning", "Elyza Virahmalia", 2026);
        bookManager.addBook(book);

        boolean removed = bookManager.removeBook("Dunia Shopie");
        assertFalse(removed);
        assertEquals(1, bookManager.getBookCount());
    }

    // Lengkapi Unit Test dibawah untuk mencari buku berdasarkan penulis
    @Test
    @DisplayName("Test mencari buku berdasarkan author")
    void testFindBookByAuthor() {
        Book b1 = new Book ("The Courage To Be Dislike", "Fumitake Koga", 2019);
        Book b2 = new Book ("Holy Mother", "Akiyoshi Rikako", 2019);
        Book b3 = new Book ("Fihi Ma Fihi", "Jalaludin Rumi", 2013);

        bookManager.addBook(b1);
        bookManager.addBook(b2);
        bookManager.addBook(b3);

        List<Book> hasil = bookManager.findBooksByAuthor("Akiyoshi Rikako");
        assertEquals(1, hasil.size());
    }

    // Lengkapi Unit Test dibawah untuk seluruh buku yang ada di dalam List
    @Test
    @DisplayName("Test mendapatkan semua buku")
    void testGetAllBooks() {
        Book b1 = new Book ("The Courage To Be Dislike", "Fumitake Koga", 2019);
        Book b2 = new Book ("Fihi Ma Fihi", "Jalaludin Rumi", 2013);

        bookManager.addBook(b1);
        bookManager.addBook(b2);

        List<Book> semua = bookManager.getAllBooks();
        assertEquals(2, semua.size());
        assertTrue(semua.contains(b1));
        assertTrue(semua.contains(b2));
    }
}
