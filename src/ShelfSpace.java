/**
 * ShelfSpace is assigned to every book, each book has a place on a shelf
 * and that shelf has attribute pointing to the shelf to the left and the
 * right of itself. The class provides methods to get those shelf spaces
 * alongside what book they hold and the ability to modify what
 * shelf space is to either direction.
 *
 * @author Maksim Strelkov
 * - no copyright
 * @version 1.0
 * @since 2024-03-10
 */

public class ShelfSpace {
    private Book book;
    private ShelfSpace leftSpace;
    private ShelfSpace rightSpace;

    /**
     * Constructor for the shelf space, with assignable pointers to
     * what is to the left and right of the existing shelf space.
     * @param book Book that is located in the current shelf space.
     */
    public ShelfSpace(Book book) {
        this.book = book;
    }

    /**
     * Returns the book in the shelf space.
     * @return The book.
     */
    public Book getBook() {
        return this.book;
    }

    /**
     * Returns the space to the left of the current shelf spot
     * @return Left shelf space
     */
    public ShelfSpace getLeftSpace() {
        return this.leftSpace;
    }

    /**
     * Returns the space to the right of the current shelf spot
     * @return right shelf space
     */
    public ShelfSpace getRightSpace() {
        return this.rightSpace;
    }

    /**
     * Assigns what is to the left of the current shelf space
     * @param leftSpace The new left shelf space
     */
    public void setLeftSpace(ShelfSpace leftSpace) {
        this.leftSpace = leftSpace;
    }

    /**
     * Assigns what is to the right of the current shelf space
     * @param rightSpace The new right shelf space
     */
    public void setRightSpace(ShelfSpace rightSpace) {
        this.rightSpace = rightSpace;
    }

    /**
     * Get the short string of the book in the current shelf spot using
     * getShortString
     * @return String including all attributes of the book object in
     * short form.
     */
    @Override
    public String toString() {
        return this.book.getShortString();
    }
}
