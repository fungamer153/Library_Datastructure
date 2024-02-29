public class Book {
    private String authorFamilyName;
    private String authorRestOfName;
    private String title;
    private String publisher;
    private int numPages;
    private int year;
    private Genre genre;
    private int bookID;
    private static int id = 1004825;

    public Book(String authorFN, String authorRN, String title, Genre genre){
        this.authorFamilyName = authorFN;
        this.authorRestOfName = authorRN;
        this.title = title;
        this.genre = genre;
        this.bookID = id++;
    }

    public Book(String authorFN, String authorRN, String title, Genre genre, int year, String publisher, int numPages){
        this.authorFamilyName = authorFN;
        this.authorRestOfName = authorRN;
        this.title = title;
        this.numPages = numPages;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.bookID = id++;
    }

    public String getAuthorFamilyNames(){
        return authorFamilyName;
    }

    public String getAuthorRestOfName(){
        return authorRestOfName;
    }

    public Genre getGenre(){
        return this.genre;
    }
    public String getTitle(){
        return title;
    }

    public int getBookID(){
        return this.bookID;
    }

    public int getNumPages(){
        return this.numPages;
    }

    public String getPublisher(){
        return this.publisher;
    }

    public int getYear() {
        return year;
    }

    public String getCitation(){
        if (this.genre == Genre.SCIENCE_FICTION){
            return this.authorFamilyName
                    + ", " + this.authorRestOfName
                    + ". " + this.title
                    + ".";
        } else if (this.genre == Genre.NON_FICTION) {
            return this.authorFamilyName
                    + ", " + this.authorRestOfName
                    + ". " + this.title
                    + ". " + this.publisher
                    + " (" + this.year
                    + ") " + this.numPages
                    + "pp.";
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
                + this.title
                + this.genre
                + this.bookID;
    }

    public String getShortString() {
        return this.authorFamilyName
                + this.authorRestOfName
                + this.title;
    }
}
