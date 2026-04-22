import java.io.Serializable;

class Showtime implements Serializable {
    private static final long serialVersionUID = 1L;
    private Movie movie;
    private String time;
    private String hall;

    public Showtime(Movie movie, String time, String hall) {
        this.movie = movie;
        this.time = time;
        this.hall = hall;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getTime() {
        return time;
    }

    public String getHall() {
        return hall;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    @Override
    public String toString() {
        return "Time: " + time + " | Hall: " + hall + " | " + movie.toString();
    }
}