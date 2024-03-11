/**
 * Shelf class represents each individual shelf that books rest on logically,
 * the class can contain any amount of books on each shelf with ability to
 * empty them, take books or purely get all books from a specified shelf.
 *
 * @author Maksim Strelkov
 * - no copyright
 * @version 1.0
 * @since 2024-03-10
 */

public class Shelf {
    private ShelfSpace leftEnd;
    private ShelfSpace rightEnd;

    /**
     * Constructor for the shelf, having attributes for both ends of itself.
     */
    public Shelf() {
        this.leftEnd = null;
        this.rightEnd = null;
    }

    /**
     * Adds a book object to the left side while pushing other books to the
     * right, if no books are present the book is placed on both shelf ends
     * @param book Book object that is to be placed on the shelf
     */
    public void addLeft(Book book) {
        ShelfSpace newSpace = new ShelfSpace(book);

        // leftEnd can only be null if there are no books on the shelf
        if (this.leftEnd == null) {
            this.leftEnd = newSpace;
            this.rightEnd = newSpace;
        } else {
            ShelfSpace oldLeft = this.leftEnd;
            this.leftEnd = newSpace;
            newSpace.setRightSpace(oldLeft);
            oldLeft.setLeftSpace(newSpace);
        }
    }

    /**
     * Takes a book from the right direction, removes the book in the process
     * and shifts the rest books accordingly.
     * @return Book from the right side of the shelf if there is any
     */
    public Book takeRight() {
        // If left end or right end are null then shelf is empty, nothing to return
        if (this.leftEnd == null || this.rightEnd == null) {return null;}
        Book lastBook = this.rightEnd.getBook();

        // Check if right end has something on the left
        if (this.rightEnd.getLeftSpace() != null) {
            ShelfSpace oldLeftSpace = this.rightEnd.getLeftSpace();
            this.rightEnd.setLeftSpace(null);

            // Determine if removed right space had anything to the left
            if (oldLeftSpace != null) {
                // If so, make that left space the new right end, remove right reference
                this.rightEnd = oldLeftSpace;
                this.rightEnd.setRightSpace(null);
            } else {
                this.leftEnd = null;
                this.rightEnd = null;
            }
        } else {
            // Set both shelf's null to indicate shelf is empty
            this.leftEnd = null;
            this.rightEnd = null;
        }

        return lastBook;
    }

    /**
     * Empties the shelf contents from the right to left
     */
    public void empty(){
        while (this.rightEnd != null) {
            Book currentBook = this.takeRight();

            if (currentBook != null) {
                System.out.println(currentBook.getShortString());
            }
        }
    }

    /**
     * Prints every title on the shelf from the left side to the right
     * @return String on if there is anything on the shelf
     */
    public String printAll() {
        ShelfSpace currentSpace = this.leftEnd;

        if (currentSpace == null) {
            return "empty";
        } else {
            /*
                While left end isn't empty recursively get
                the book from the right side without removing it
                and output the shortened citation to the terminal
             */
            while (currentSpace != null) {
                Book currentBook = currentSpace.getBook();
                currentSpace = currentSpace.getRightSpace();
                System.out.println(currentBook.getShortString());
            }

            return "";
        }
    }
}
