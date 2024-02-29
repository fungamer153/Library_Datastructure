
public class ShelfSpace {
    final private Book assignedBook;
    private ShelfSpace leftSpace;
    private ShelfSpace rightSpace;

   public ShelfSpace(Book book){
       this.assignedBook = book;
   }

    public Book getThisBook() {
        return assignedBook;
    }

    public ShelfSpace getLeftSpace() {
        return leftSpace;
    }

    public ShelfSpace getRightSpace() {
        return rightSpace;
    }

    public void setLeftSpace(ShelfSpace leftSpace) {
        this.leftSpace = leftSpace;
    }

    public void setRightSpace(ShelfSpace rightSpace) {
        this.rightSpace = rightSpace;
    }

    @Override
    public String toString() {
        return this.assignedBook.getShortString();
    }
}
