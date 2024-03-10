import java.util.ArrayList;

public class Library {
    Shelf incoming;
    private ArrayList<Book> sciFi;
    private ArrayList<Book> nonFiction;
    private ArrayList<Book> crime;
    private ArrayList<Book> fantasy;
    private ArrayList<Book> romance;

    public Library(Shelf incoming){
        this.incoming = incoming;
        this.sciFi = new ArrayList<>();
        this.nonFiction = new ArrayList<>();
        this.crime = new ArrayList<>();
        this.fantasy = new ArrayList<>();
        this.romance = new ArrayList<>();
    }

    public ArrayList<Book> getSciFi(){
        return this.sciFi;
    }

    public ArrayList<Book> getNonFiction(){
        return this.nonFiction;
    }

    public ArrayList<Book> getCrime(){
        return this.crime;
    }

    public ArrayList<Book> getFantasy(){
        return this.fantasy;
    }

    public ArrayList<Book> getRomance(){
        return this.romance;
    }

    public void process(){
        this.incoming.empty();
    }

    public void search(Genre neededGenre, String bookTitle){
//        boolean foundResults = false;
//        ArrayList<Book> neededShelf = new ArrayList<>();;
//
//        if (neededGenre == Genre.SCIENCE_FICTION){
//            neededShelf = this.sciFi;
//        } else if (neededGenre == Genre.NON_FICTION) {
//            neededShelf = this.nonFiction;
//        } else if (neededGenre == Genre.CRIME) {
//            neededShelf = this.crime;
//        } else if (neededGenre == Genre.FANTASY) {
//            neededShelf = this.fantasy;
//        } else if (neededGenre == Genre.ROMANCE) {
//            neededShelf = this.romance;
//        }
//
//        for (Book book : neededShelf) {
//            if (book.getTitle().contains(bookTitle)) {
//                //System.out.println(book.getCitation());
//                foundResults = true;
//            }
//        }
//
//        if (!foundResults) {
//            System.out.println("No results found.");
//        }
    }
}
