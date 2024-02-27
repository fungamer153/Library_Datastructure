import java.util.LinkedList;

public class ShelfSpace {
    final private Book assignedBook;
    private LinkedList<Book> leftEnd;
    private LinkedList<Book>  rightEnd;

   public ShelfSpace(Book book){
       this.assignedBook = book;
       this.leftEnd = new LinkedList<Book>();
       this.rightEnd = new LinkedList<Book>();
   }

   public Book getBook(){
       return this.assignedBook;
   }


   public ShelfSpace getRightSpace(){
       return shelfSpace;
   }

   public void addLeft(Book book){
       this.leftEnd.add(book);
   }

   public void addRight(Book book){
       this.rightEnd.add(book);
   }

   public void setLeftSpace(){

   }

    public void setRightSpace(){

    }
}
