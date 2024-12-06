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

@Test
    public void testBookId() throws Exception{
        Book book1 = new Book (100, " valid ID");
        Book book2 = new Book (999, " valid ID");

        
        assertTrue(book1.isValidId(100));
        assertTrue(book2.isValidId(999));

        
      assertThrows(Exception.class, () -> new Book(99, "Error small number detected! pick from 100 - 999"));
      assertThrows (Exception.class, () -> new Book(1000, "Error large number detected! pick from 100 - 999"));
    }


@Test
    public void testBorrowReturn() {
        
        assertTrue(book1.isAvailable());
        assertTrue(book2.isAvailable());

        
        boolean borrowResult = transaction.borrowBook(book1, member1);
        assertTrue(borrowResult); 
        assertFalse(book1.isAvailable()); 

        
        borrowResult = transaction.borrowBook(book1, member1);
        assertFalse(borrowResult); 

        
        boolean returnResult = transaction.returnBook(book1, member1);
        assertTrue(returnResult);
        assertTrue(book1.isAvailable()); 

                returnResult = transaction.returnBook(book1, member1);
        assertFalse(returnResult); 
    }