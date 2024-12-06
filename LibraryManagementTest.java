import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class LibraryManagementTest {
    
    private Book book1;
    private Book book2;
    private Member member1;
    private Library library;
    private Transaction transaction;

@Before
    public void setUp() {
        
        library = new Library();
        try {
            book1 = new Book(100, "Book 1"); 
            book2 = new Book(200, "Book 2"); 
            library.addBook(book1);
            library.addBook(book2);
        } catch (Exception e) {
            fail("Error while initializing books" + e.getMessage());
        }
        member1 = new Member(1, "Anna Green");
        transaction = Transaction.getTransaction();
    }
