public class ShelfSpace {
    private final Book book;
    private ShelfSpace leftSpace;
    private ShelfSpace rightSpace;

    public ShelfSpace(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return this.book;
    }

    public ShelfSpace getLeftSpace() {
        return this.leftSpace;
    }

    public ShelfSpace getRightSpace() {
        return this.rightSpace;
    }

    public void setLeftSpace(ShelfSpace leftSpace) {
        this.leftSpace = leftSpace;
    }

    public void setRightSpace(ShelfSpace rightSpace) {
        this.rightSpace = rightSpace;
    }

    @Override
    public String toString() {
        return this.book.getShortString();
    }
}
