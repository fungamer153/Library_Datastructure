public class BookUnitTest {
    public static void main(String[] args) {
        Book newBook = new Book("test", "test", "test");
        testConstructorAndGetters(newBook);
    }


    public static void testConstructorAndGetters(Book newBook){
        newBook.setTitle("Planetfall");
        newBook.setAuthorFamilyName("Emma");
        newBook.setAuthorRestOfName("Newman");
        System.out.println(newBook.getBookID());
        System.out.println(newBook.getTitle());
        System.out.println(newBook.getAuthorFamilyName());
        System.out.println(newBook.getAuthorRestOfName());
    }

    public static void testSetters(Book newBook){
        newBook.setTitle("Planetfall");
        newBook.setAuthorFamilyName("Emma");
        newBook.setAuthorRestOfName("Newman");
    }

    public static void testBookID(Book newBook){
        System.out.println(newBook.getBookID());
    }

    public static void testToString(Book newBook){
        System.out.println(newBook.toString());
    }
}
