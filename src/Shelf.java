public class Shelf {
    ShelfSpace leftEnd;
    ShelfSpace rightEnd;

    public Shelf() {
        this.leftEnd = null;
        this.rightEnd = null;
    }

    public void addLeft(Book book){
        if (this.leftEnd == null) {
            this.leftEnd = new ShelfSpace(book);
            this.rightEnd = new ShelfSpace(book);
        } else {
            this.leftEnd = new ShelfSpace(this.leftEnd.getBook());
            this.leftEnd.setRightSpace(this.leftEnd);
        }
    }

    public void takeRight(Book book){

    }

    public static void main(String[] args) {
        Shelf shelf = new Shelf();
        shelf.addLeft(new Book("SchwabV", "Newman", "Magic", Genre.SCIENCE_FICTION));
        System.out.println(shelf.leftEnd.getRightSpace());
        shelf.addLeft(new Book("Joe", "Newman", "Justice", Genre.SCIENCE_FICTION));
        System.out.println(shelf.leftEnd.getRightSpace());
    }
}
