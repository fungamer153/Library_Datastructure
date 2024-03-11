/**
 * Unit test class used to test methods from the book class, its mutator
 * and getter methods to ensure the code is structured properly for later stages.
 *
 * @author Maksim Strelkov
 * - no copyright
 * @version 1.0
 * @since 2024-03-10
 */

public class BookUnitTest {
    /** The book class used for unit testing */
    static Book newBook;

    public static void main(String[] args) {
        System.out.println("Expected title: " + "Planetfall");
        System.out.println("Expected short string: " + "PlanetfallEmmaNewman");
        System.out.println("Expected citation: " + "Planetfall, Emma. Newman.");
        testConstructorAndGetters();

        System.out.println("Expected ID: " + 1004825);
        testBookID();

        testSetters();
        testToString();
        System.out.println("Expected toString: " + "maozedongmao zedongSCIENCE_FICTION1004825");
    }

    /**
     * Tests the constructor creating new book object and then getting the
     * appropriate book information
     */
    public static void testConstructorAndGetters() {
        newBook = new Book("Planetfall", "Emma", "Newman", Genre.SCIENCE_FICTION);

        System.out.println("Actual title: " + newBook.getTitle());
        System.out.println("Actual short string: " + newBook.getShortString());
        System.out.println("Actual citation: " + newBook.getCitation());
    }

    /**
     * Test if setters set the new book information
     */
    public static void testSetters() {
        newBook.setTitle("mao zedong");
        newBook.setAuthorFamilyName("mao");
        newBook.setAuthorRestOfName("zedong");
    }

    /**
     * Test if book ID is set properly
     */
    public static void testBookID() {
        System.out.println("Actual ID: " + newBook.getBookID());
    }

    /**
     * Test if toString method works correctly
     */
    public static void testToString() {
        System.out.println("Actual toString: " + newBook.toString());
    }
}
