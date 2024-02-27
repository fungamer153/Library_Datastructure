public class Book {
    private String authorFamilyName;
    private String authorRestOfName;
    private String title;
    private String publisher;
    private int numPages;
    private int year;
    private int bookID = 1004824;
    private Genres.genres genre;

    public Book(String authorFN, String authorRN, String title, String publisher, int pages, int year, Genres.genres bGenre){
        this.authorFamilyName = authorFN;
        this.authorRestOfName = authorRN;
        this.title = title;
        this.publisher = publisher;
        this.numPages = pages;
        this.year = year;
        this.genre = bGenre;
        this.bookID = bookID;
        bookID++;
    }

    public String getAuthorFamilyName(){
        return authorFamilyName;
    }

    public String getAuthorRestOfName(){
        return authorRestOfName;
    }

    public String getTitle(){
        return title;
    }

    public int getBookID(){
        return this.bookID;
    }

    public String getCitation(){
        if (this.genre == Genres.genres.NON_FICTION) {
            return this.authorFamilyName
                    + ", " + this.authorRestOfName
                    + ". " + this.title
                    + ". " + this.publisher
                    + " " + this.year
                    + " " + this.numPages;
        } else if (this.genre == Genres.genres.SCIENCE_FICTION) {
            return this.authorFamilyName
                    + ", " + this.authorRestOfName
                    + ". " + this.title;
        }

        return "";
    }

    public void setAuthorFamilyName(String authorFamilyName){
        this.authorFamilyName = authorFamilyName;
    }

    public void setAuthorRestOfName(String authorRestOfName){
        this.authorRestOfName = authorRestOfName;
    }

    public void setTitle(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return this.authorFamilyName
                + this.authorRestOfName
                + this.title;
    }

    public String getShortString() {
        return this.authorRestOfName
                + this.authorFamilyName
                + this.title;
    }
}
