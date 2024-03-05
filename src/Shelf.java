public class Shelf {
    ShelfSpace leftEnd;
    ShelfSpace rightEnd;

    public Shelf() {
        this.leftEnd = null;
        this.rightEnd = null;
    }

    public void addLeft(Book book) {
        ShelfSpace oldLeft = this.leftEnd;
        ShelfSpace newSpace = new ShelfSpace(book);

        if (this.leftEnd == null) {
            // Shelf is empty, add the book to both left and right ends
            this.leftEnd = newSpace;
            this.rightEnd = newSpace;
        } else {
            // Shelf is not empty, update references
            this.leftEnd = newSpace;
            this.leftEnd.setRightSpace(oldLeft);

            if (this.rightEnd.getLeftSpace() == null) {
                this.rightEnd.setLeftSpace(this.leftEnd);
            } else {
                this.rightEnd.setLeftSpace(oldLeft);
            }
        }
    }

    public Book takeRight() {
        Book lastBook = this.rightEnd.getBook();
        Book leftBook = this.rightEnd.getLeftSpace().getBook();

        if (this.rightEnd.getLeftSpace() == null && this.leftEnd.getRightSpace() == null) {
            this.rightEnd = null;
            this.leftEnd = null;
        } else if (this.rightEnd.getLeftSpace() == this.leftEnd) {
            this.rightEnd = new ShelfSpace(this.leftEnd.getBook());
            this.leftEnd = rightEnd;
        } else {
            this.rightEnd = new ShelfSpace(leftBook);
            this.rightEnd.setLeftSpace(this.leftEnd);
        }

        return lastBook;
    }
}