import java.io.Serializable;

class Movie implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String genre;
    private String rating;
    private int year;

    public Movie(String title, String genre, String rating, int year) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "[" + rating + "] " + title + " | Genre: " + genre + " | Year: " + year;
    }
}