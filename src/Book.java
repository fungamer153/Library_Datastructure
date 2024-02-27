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
