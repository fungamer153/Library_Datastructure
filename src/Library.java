import java.util.ArrayList;

public class Library {
    private final Shelf incoming;
    private final ArrayList<Book> sciFi;
    private final ArrayList<Book> nonFiction;
    private final ArrayList<Book> crime;
    private final ArrayList<Book> fantasy;
    private final ArrayList<Book> romance;

    public Library(Shelf incoming) {
        this.incoming = incoming;
        this.sciFi = new ArrayList<>();
        this.nonFiction = new ArrayList<>();
        this.crime = new ArrayList<>();
        this.fantasy = new ArrayList<>();
        this.romance = new ArrayList<>();
    }

    public ArrayList<Book> getSciFi() {
        return this.sciFi;
    }

    public ArrayList<Book> getNonFiction() {
        return this.nonFiction;
    }

    public ArrayList<Book> getCrime() {
        return this.crime;
    }

    public ArrayList<Book> getFantasy() {
        return this.fantasy;
    }

    public ArrayList<Book> getRomance() {
        return this.romance;
    }

    public void process() {
        while (true) {
            Book newBook = incoming.takeRight();

            if (newBook == null) {
                break;
            }

            switch (newBook.getGenre()) {
                case SCIENCE_FICTION:
                    this.sciFi.add(newBook);
                    break;
                case NON_FICTION:
                    this.nonFiction.add(newBook);
                    break;
                case CRIME:
                    this.crime.add(newBook);
                    break;
                case FANTASY:
                    this.fantasy.add(newBook);
                    break;
                case ROMANCE:
                    this.romance.add(newBook);
                    break;
                default:
                    break;
            }
        }
    }

    public void search(Genre neededGenre, String bookTitle) {
        boolean foundResults = false;
        ArrayList<Book> neededShelf = new ArrayList<>();;

        switch (neededGenre) {
            case SCIENCE_FICTION:
                neededShelf = this.sciFi;
                break;
            case NON_FICTION:
                neededShelf = this.nonFiction;
                break;
            case CRIME:
                neededShelf = this.crime;
                break;
            case FANTASY:
                neededShelf = this.fantasy;
                break;
            case ROMANCE:
                neededShelf = this.romance;
                break;
            default:
                break;
        }

        for (Book book: neededShelf) {
            if (book.getTitle().contains(bookTitle)) {
                System.out.println(book.getCitation());
                foundResults = true;
            }
        }

        if (!foundResults) {
            System.out.println("No results found.");
        }
    }
}
