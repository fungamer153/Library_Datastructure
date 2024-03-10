public class Book {
    private String[] authors = {};
    private String authorFamilyName;
    private String authorRestOfName;
    private String title;
    private String publisher;
    private int numPages;
    private int year;
    private final int bookID;
    private static int id = 1004825;
    private final Genre genre;


    public Book(String authorFN, String authorRN, String title, Genre genre) {
        this.authorFamilyName = authorFN;
        this.authorRestOfName = authorRN;
        this.title = title;
        this.genre = genre;
        this.bookID = id++;
    }

    public Book(String authorFN, String authorRN, String title, Genre genre, int year, String publisher, int numPages) {
        this.authorFamilyName = authorFN;
        this.authorRestOfName = authorRN;
        this.title = title;
        this.numPages = numPages;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.bookID = id++;
    }

    public Book(String[] authors, String title, Genre genre, int year, String publisher, int numPages) {
        this.authors = authors;
        this.title = title;
        this.numPages = numPages;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.bookID = id++;
    }

    public String getAuthorFamilyNames() {
        if (this.authorFamilyName != null) {
            return this.authorFamilyName;
        } else {
            return this.authors[1];
        }
    }

    public String getAuthorRestOfName() {
        return this.authorRestOfName;
    }

    public Genre getGenre() {
        return this.genre;
    }
    public String getTitle() {
        return this.title;
    }

    public int getBookID() {
        return this.bookID;
    }

    public int getNumPages() {
        return this.numPages;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public int getYear() {
        return year;
    }

    public String getCitation() {
        if (this.authorFamilyName == null) {
            String finalOutput = "";

            for (int i = 0; i < this.authors.length; i += 2){
                if (i + 1 >= this.authors.length) {
                    finalOutput += this.authors[i] + ".";
                } else {
                    finalOutput += this.authors[i] + ", " + this.authors[i + 1] + (i < this.authors.length - 2 ? " and " : ".");
                }
            }

            finalOutput += " " + this.title
                    + ". " + this.publisher
                    + " (" + this.year
                    + ") " + this.numPages
                    + "pp.";

            return finalOutput;
        } else {
            if (this.genre == Genre.SCIENCE_FICTION) {
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
        }

        return "";
    }

    public void setAuthorFamilyName(String authorFamilyName) {
        this.authorFamilyName = authorFamilyName;
    }

    public void setAuthorFamilyNames(String name) {
        if (this.authors.length == 0) {
            this.authors = new String[]{name};
        } else {
            String[] newAuthors = new String[this.authors.length + 1];

            for (int i = 0; i < this.authors.length; i++) {
                newAuthors[i] = this.authors[i];
            }

            newAuthors[this.authors.length] = name;
            this.authors = newAuthors;
        }
    }

    public void setAuthorRestOfName(String authorRestOfName) {
        this.authorRestOfName = authorRestOfName;
    }

    public void setTitle(String title) {
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
        if (this.authorFamilyName != null) {
            return this.authorFamilyName
                    + this.authorRestOfName
                    + this.title;
        } else {
            return this.authors[1].toUpperCase()
                    + this.authors[0].toUpperCase()
                    + "et al."
                    + this.title;
        }
    }
}
