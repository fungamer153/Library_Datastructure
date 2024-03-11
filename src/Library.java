import java.util.ArrayList;

/**
 * Library class contains different genre ArrayLists alongside mutator
 * and getter methods that aid in processing of books into their adequate
 * genre ArrayLists, that can be later gotten and utilised in searching
 * method to find books with matching titles.
 *
 * @author Maksim Strelkov
 * - no copyright
 * @version 1.0
 * @since 2024-03-10
 */

public class Library {
    private Shelf incoming;
    private final ArrayList<Book> sciFi;
    private final ArrayList<Book> nonFiction;
    private final ArrayList<Book> crime;
    private final ArrayList<Book> fantasy;
    private final ArrayList<Book> romance;

    /**
     * Constructor for the library containing incoming shelf that serves
     * as a waiting buffer, where eventually books will be removed from
     * into their respective genre ArrayLists.
     * @param incoming Shelf of books of any genres.
     */
    public Library(Shelf incoming) {
        this.incoming = incoming;
        this.sciFi = new ArrayList<>();
        this.nonFiction = new ArrayList<>();
        this.crime = new ArrayList<>();
        this.fantasy = new ArrayList<>();
        this.romance = new ArrayList<>();
    }

    /**
     * Returns ArrayList that contains sci-fi genre books.
     * @return sciFi ArrayList
     */
    public ArrayList<Book> getSciFi() {
        return this.sciFi;
    }

    /**
     * Returns ArrayList that contains non-fiction genre books.
     * @return nonFiction ArrayList
     */
    public ArrayList<Book> getNonFiction() {
        return this.nonFiction;
    }

    /**
     * Returns ArrayList that contains crime genre books.
     * @return crime ArrayList
     */
    public ArrayList<Book> getCrime() {
        return this.crime;
    }

    /**
     * Returns ArrayList that contains fantasy genre books.
     * @return fantasy ArrayList
     */
    public ArrayList<Book> getFantasy() {
        return this.fantasy;
    }

    /**
     * Returns ArrayList that contains romance genre books.
     * @return romance ArrayList
     */
    public ArrayList<Book> getRomance() {
        return this.romance;
    }

    /**
     * Recursively runs until all books on the incoming shelf are sorted
     * into their respective genre ArrayLists.
     */
    public void process() {
        while (true) {
            Book newBook = incoming.takeRight();

            if (newBook == null) {
                break;
            }

            /*
                Depending on what genre the book is, sort it
                to the appropriate ArrayList genre.
             */
            switch (newBook.getGenre()) {
                case SCIENCE_FICTION:
                    this.sciFi.add(newBook);
                    break;
                case NON_FICTION:
                    this.nonFiction.add(newBook);
                    break;
                case CRIME:
                    this.crime.add(newBook);
                    break;
                case FANTASY:
                    this.fantasy.add(newBook);
                    break;
                case ROMANCE:
                    this.romance.add(newBook);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Searches for books of similar title within a specific genre category.
     * @param neededGenre Enum genre that you want to search within.
     * @param bookTitle Part of the title of the book you need.
     */
    public void search(Genre neededGenre, String bookTitle) {
        boolean foundResults = false;
        ArrayList<Book> neededShelf = new ArrayList<>();;

        /*
            Fetch the correct ArrayList based on what genre we want to search,
            using the getter methods return the already created ArrayList.
         */
        switch (neededGenre) {
            case SCIENCE_FICTION:
                neededShelf = getSciFi();
                break;
            case NON_FICTION:
                neededShelf = getNonFiction();
                break;
            case CRIME:
                neededShelf = getCrime();
                break;
            case FANTASY:
                neededShelf = getFantasy();
                break;
            case ROMANCE:
                neededShelf = getRomance();
                break;
            default:
                break;
        }

        // Pairs loop to be able to immediately use the fetched object
        for (Book book: neededShelf) {
            // If the book title contains any of our initial search keyword
            if (book.getTitle().contains(bookTitle)) {
                System.out.println(book.getCitation());
                foundResults = true;
            }
        }

        // If we had no matches within the specified genre
        if (!foundResults) {
            System.out.println("No results found.");
        }
    }
}
