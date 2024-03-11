/**
 * Book class represents a created book object that contains mutator and getter
 * methods allowing the book object to be modified and have its contents
 * output to terminal or returned.
 *
 * @author Maksim Strelkov
 * - no copyright
 * @version 1.0
 * @since 2024-03-10
 */

public class Book {
    /** String array for multi authored books */
    private String[] authors = {};

    /** Author names for books written by single author */
    private String authorFamilyName;
    private String authorRestOfName;

    /** Information pertaining the created book object */
    private String title;
    private String publisher;
    private int numPages;
    private int year;
    private final int bookID;

    /** Unique id that is set for each book, begins from 1004825 */
    private static int id = 1004825;
    private final Genre genre;

    /**
     * Basic Book class constructor for books with a single author.
     * @param authorFN Author's family name.
     * @param authorRN Rest of author's name.
     * @param title What the book is called.
     * @param genre What genre the book belongs in.
     */
    public Book(String authorFN, String authorRN, String title, Genre genre) {
        this.authorFamilyName = authorFN;
        this.authorRestOfName = authorRN;
        this.title = title;
        this.genre = genre;
        this.bookID = id++;
    }

    /**
     * Book class constructor with more in-depth information for books with a
     * single author.
     * @param authorFN Author's family name.
     * @param authorRN Rest of author's name.
     * @param title What the book is called.
     * @param genre What genre the book belongs in.
     * @param year What year the book was released in.
     * @param publisher The group / person that released it.
     * @param numPages How many pages it contains.
     */
    public Book(String authorFN, String authorRN, String title, Genre genre, int year, String publisher, int numPages) {
        this.authorFamilyName = authorFN;
        this.authorRestOfName = authorRN;
        this.title = title;
        this.numPages = numPages;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.bookID = id++;
    }

    /**
     * Book class constructor for books with multiple authors, with in-depth
     * detail about the book.
     * @param authors Array containing strings of author's family name
     *                and rest of their name.
     * @param title What the book is called.
     * @param genre What genre the book belongs in.
     * @param year What year the book was released in.
     * @param publisher The group / person that released it.
     * @param numPages How many pages it contains.
     */
    public Book(String[] authors, String title, Genre genre, int year, String publisher, int numPages) {
        this.authors = authors;
        this.title = title;
        this.numPages = numPages;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.bookID = id++;
    }

    /**
     * Returns the author's family name, if the book has multiple authors
     * then returns the first author's family name.
     * @return String containing the author's family name.
     */
    public String getAuthorFamilyNames() {
        //Check on if the book object contains multiple authors,
        //choose what way we want to return correct string
        if (this.authorFamilyName != null) {
            return this.authorFamilyName;
        } else {
            return this.authors[1];
        }
    }

    /**
     * Gets the rest of author's name.
     * @return String containing the rest of author's name.
     */
    public String getAuthorRestOfName() {
        return this.authorRestOfName;
    }

    /**
     * Gets the genre that the book is in.
     * @return A genre enum of the genre that book is in.
     */
    public Genre getGenre() {
        return this.genre;
    }

    /**
     * Gets the title of the book.
     * @return String containing title of the book.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the unique book ID from the book.
     * @return Integer of the ID.
     */
    public int getBookID() {
        return this.bookID;
    }

    /**
     * Gets how many pages the book contains.
     * @return Integer of how many pages are in the book.
     */
    public int getNumPages() {
        return this.numPages;
    }

    /**
     * Gets the person / group that published the book.
     * @return String that contains name of the publisher.
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * Gets the year the book was released in.
     * @return Integer of the year the book was released in.
     */
    public int getYear() {
        return year;
    }

    /**
     * Outputs a citation depending on what genre the book is set in,
     * including essential book information like the publisher, year and
     * how many pages are inside.
     * @return Formatted string of the books' information.
     */
    public String getCitation() {
        // Check on if the object has multiple authors or not
        if (this.authorFamilyName == null) {
            // If multiple authors construct a string of authors
            String finalOutput = "";

            for (int i = 0; i < this.authors.length; i += 2){
                // If we reach end of authors then add a comma
                if (i + 1 >= this.authors.length) {
                    finalOutput += this.authors[i] + ".";
                } else {
                    // If not end of the author array then add author name
                    // onto the last one
                    finalOutput += this.authors[i] + ", "
                            + this.authors[i + 1]
                            + (i < this.authors.length - 2 ? " and " : ".");
                }
            }

            finalOutput += " " + this.title
                    + ". " + this.publisher
                    + " (" + this.year
                    + ") " + this.numPages
                    + "pp.";

            return finalOutput;
        } else {
            // If no multiple authors, proceed with normal execution
            if (this.genre == Genre.SCIENCE_FICTION) {
                return this.authorFamilyName
                        + ", " + this.authorRestOfName
                        + ". " + this.title
                        + ".";
            } else {
                return this.authorFamilyName
                        + ", " + this.authorRestOfName
                        + ". " + this.title
                        + ". " + this.publisher
                        + " (" + this.year
                        + ") " + this.numPages
                        + "pp.";
            }
        }
    }

    /**
     * Sets the author's family name to the given string.
     * @param authorFamilyName String of the new family name.
     */
    public void setAuthorFamilyName(String authorFamilyName) {
        this.authorFamilyName = authorFamilyName;
    }

    /**
     * Adds an authors name to the list if the book has multiple authors.
     * @param name Name of the new added author.
     */
    public void setAuthorFamilyNames(String name) {
        // If author array is empty, create new array with first record being
        // the new added name
        if (this.authors.length == 0) {
            this.authors = new String[]{name};
        } else {
            String[] newAuthors = new String[this.authors.length + 1];

            for (int i = 0; i < this.authors.length; i++) {
                newAuthors[i] = this.authors[i];
            }

            newAuthors[this.authors.length] = name;
            this.authors = newAuthors;
        }
    }

    /**
     * Set the rest of author's name for the book to given string.
     * @param authorRestOfName The new rest of authors name.
     */
    public void setAuthorRestOfName(String authorRestOfName) {
        this.authorRestOfName = authorRestOfName;
    }

    /**
     * Set the book title to the new given string
     * @param title The new title for the book.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Format all attributes of the class into a readable string
     * @return String including all attributes of the book object.
     */
    @Override
    public String toString() {
        return this.authorFamilyName
                + this.authorRestOfName
                + this.title
                + this.genre
                + this.bookID;
    }

    /**
     * Formats a shorter version of toString.
     * @return Less attribute information pertaining to the book.
     */
    public String getShortString() {
        // If there are no multiple authors then proceed with 1st selection
        if (this.authorFamilyName != null) {
            return this.authorFamilyName
                    + this.authorRestOfName
                    + this.title;
        } else {
            return this.authors[1].toUpperCase()
                    + this.authors[0].toUpperCase()
                    + "et al."
                    + this.title;
        }
    }
}
