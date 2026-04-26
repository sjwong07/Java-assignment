import java.util.ArrayList;
import java.io.*;

class DataManager {
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Movie> movies = new ArrayList<>();
    private static ArrayList<Showtime> showtimes = new ArrayList<>();
    private static final String FILE_NAME = "cinema_data.json";
    
     public void saveData() {
        try 
        (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
            
            oos.writeObject(users);
            oos.writeObject(movies);
            oos.writeObject(showtimes);
        } catch (IOException e) {
            System.out.println("File Error: Could not save data.");
        }
    }


    @SuppressWarnings("unchecked")
    public void loadData() {
        File f = new File(FILE_NAME);
        if (!f.exists()) {
            System.out.println("No save file exist.");
            return;
        }
        try 
        (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
            users = (ArrayList<User>) ois.readObject();
            movies = (ArrayList<Movie>) ois.readObject();
            showtimes = (ArrayList<Showtime>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Initializing system database...");
        }
    }

     public  ArrayList<User> getUsers() {
        return users;
    }
    
    public  ArrayList<Movie> getMovies() {
        return movies;
    }
    
    public  ArrayList<Showtime> getShowtimes() {
        return showtimes;
    }
}
