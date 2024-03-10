public class Shelf {
    private ShelfSpace leftEnd;
    private ShelfSpace rightEnd;

    public Shelf() {
        this.leftEnd = null;
        this.rightEnd = null;
    }

    public void addLeft(Book book) {
        ShelfSpace newSpace = new ShelfSpace(book);

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

    public Book takeRight() {
        if (this.leftEnd == null || this.rightEnd == null) {return null;}
        Book lastBook = this.rightEnd.getBook();

        if (this.rightEnd.getLeftSpace() != null) {
            Book leftBook = this.rightEnd.getLeftSpace().getBook();
            ShelfSpace oldLeftSpace = this.rightEnd.getLeftSpace();

            this.rightEnd.setLeftSpace(null);  // Remove the reference to the left space

            if (oldLeftSpace != null) {
                this.rightEnd = oldLeftSpace;
                this.rightEnd.setRightSpace(null);
            } else {
                this.leftEnd = null;
                this.rightEnd = null;
            }
        } else {
            this.leftEnd = null;
            this.rightEnd = null;
        }

        return lastBook;
    }

    public void empty(){
        while (this.rightEnd != null){
            Book currentBook = this.takeRight();

            if (currentBook != null){
                System.out.println(currentBook.getShortString());
            }
        }
    }

    public String printAll(){
        ShelfSpace currentSpace = this.leftEnd;

        if (currentSpace == null) {
            return "empty";
        } else {
            while (currentSpace != null) {
                Book currentBook = currentSpace.getBook();
                currentSpace = currentSpace.getRightSpace();

                System.out.println(currentBook.getShortString());
            }

            return "";
        }
    }
}