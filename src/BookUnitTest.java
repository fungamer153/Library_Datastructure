public class BookUnitTest {
    static Book newBook;
    public static void main(String[] args) {
        newBook = new Book("Emma", "Newman", "Planetfall", Genre.SCIENCE_FICTION);
    }

    public static void testConstructorAndGetters(){
    }

    public static void testSetters(){
        newBook.setTitle("Planetfall");
        newBook.setAuthorFamilyName("Emma");
        newBook.setAuthorRestOfName("Newman");
    }

    public static void testBookID(){
        System.out.println(newBook.getBookID());
    }

    public static void testToString(){
        System.out.println(newBook.toString());
    }
}
