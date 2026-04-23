import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

class ViewSchedule {
        Scanner scan = new Scanner(System.in);
        DataManager dm = new DataManager();
        // Declare these as class-level variables
        private ArrayList<Movie> movies = new ArrayList<>();
        private ArrayList<Showtime> showtimes = new ArrayList<>();
        private ArrayList<User> users = new ArrayList<>();
        private static User currentUser = null;  // Store current user object
        private Account acc;
  
    public ViewSchedule(Account acc) {
       
        this.acc = acc;
        this.users = dm.getUsers();
        this.movies = dm.getMovies();
        this.showtimes = dm.getShowtimes();
    }
    
    // Method to set current user (call this after login)
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;  
    }

    public static boolean isValidGenre(String genre) {
        return Pattern.compile("^[a-zA-Z\\s]+$").matcher(genre).matches();
    }

    public static boolean isValidTime(String time) {
        String t = time.toUpperCase();
        return t.endsWith("AM") || t.endsWith("PM");
    }
    

    public void displayLogoutMessage() {
    if (this.currentUser == null) {
        System.out.println("You need to login first before logging out.");
    } 
}


    public void movieMenu() { 
    while (true) {
        System.out.println("\n--- MOVIE MANAGEMENT ---");

        boolean isStaffOrAdmin = (currentUser != null && (currentUser.getRole() == 1 || currentUser.getRole() == 2));
        
        if (isStaffOrAdmin) {
            System.out.println("1. Add Movie");
            System.out.println("2. Add Showtime");
            System.out.println("3. View Schedule");
            System.out.println("4. Back");
        } else {
            System.out.println("1. View Schedule");
            System.out.println("2. Back");
        }

        System.out.print("Selection: ");
        String choice = scan.nextLine();

        
        if (choice.equals("1") && isStaffOrAdmin) {
            System.out.print("Movie Title: "); 
            String t = scan.nextLine();
            
            System.out.print("Genre (Alphabet Only): "); 
            String g = scan.nextLine();
            if (!isValidGenre(g)) { 
                System.out.println("Error: Genre invalid."); 
                continue; 
            }
            
            System.out.print("Age Rating: "); 
            String r = scan.nextLine();
            
            try {
                System.out.print("Year (Integer Only): ");
                int y = Integer.parseInt(scan.nextLine());
                
                movies.add(new Movie(t, g, r, y));
                dm.saveData();
                System.out.println("Movie added successfully!");
            } catch (NumberFormatException e) { 
                System.out.println("Error: Invalid Year."); 
            }
        }
        
        else if (choice.equals("2") && isStaffOrAdmin) {
            if (movies.isEmpty()) { 
                System.out.println("Add movies first."); 
                continue; 
            }
            
            for (int i = 0; i < movies.size(); i++) {
                System.out.println((i+1) + ". " + movies.get(i));
            }
            
            try {
                System.out.print("Select Movie No: ");
                int mIdx = Integer.parseInt(scan.nextLine()) - 1;
                
                if (mIdx < 0 || mIdx >= movies.size()) {
                    System.out.println("Error: Invalid movie number.");
                    continue;
                }
                
                System.out.print("Time (AM/PM): "); 
                String time = scan.nextLine();
                
                if (isValidTime(time)) {
                    System.out.print("Hall: "); 
                    String h = scan.nextLine();
                    
                    showtimes.add(new Showtime(movies.get(mIdx), time.toUpperCase(), h));
                    dm.saveData();
                    System.out.println("Showtime added successfully!");
                } else { 
                    System.out.println("Error: Include AM or PM."); 
                }
            } catch (Exception e) { 
                System.out.println("Error: Invalid selection."); 
            }
        }
       
        else if ((isStaffOrAdmin && choice.equals("3")) || (!isStaffOrAdmin && choice.equals("1"))) {
            if (showtimes.isEmpty()) {
                System.out.println("No showtimes available.");
            } else {
                System.out.println("\n--- CURRENT SHOWTIMES ---");
                for (Showtime s : showtimes) {
                    System.out.println("- " + s);
                }
            }
        }
        
        else if ((isStaffOrAdmin && choice.equals("4")) || (!isStaffOrAdmin && choice.equals("2"))) {
            break;
        }
        else {
            System.out.println("Invalid selection. Please try again.");
        }
    }
}

    public boolean Logout() {  
        users = dm.getUsers();  
        movies = dm.getMovies(); 
        showtimes = dm.getShowtimes(); 
        
        while (currentUser != null) {
            System.out.println("Confirm to Logout?:(Y/N)");
            System.out.print("Selection: ");
            String choice = scan.nextLine();

             if ("y".equalsIgnoreCase(choice)) {
                currentUser = null;
                System.out.println("Logged out successfully!");
                System.out.println("Do you want back to main page?(Y/N): ");
                String ans = scan.nextLine();
                if("y".equalsIgnoreCase(ans)){
                return true;  //  logout success
                }
                else{
                    //exit system
                    System.out.println("See you again,bye!");
                    System.exit(0);
                }
            }
            else if("n".equalsIgnoreCase(choice)){
                return false;//continue
            }
             else {
            System.out.println("Invalid input.");
        }
        }
        return false;
    }

    public void adminMenu() {  
        while (true) {
            System.out.println("\n--- ADMIN MANAGEMENT ---");
            System.out.println("1. Register New Staff/Admin");
            System.out.println("2. View All Users");
            System.out.println("3. View Movie Schedule");
            System.out.println("4. Back to Main Menu");
            System.out.println("5. Logout");
            System.out.print("Selection: ");
            int choice =scan.nextInt();
             scan.nextLine();

            if (choice == 1) {
                acc.handleRegister(true);//only admin or staff  
            } else if (choice == 2) {
                adminUserList();
            } else if (choice ==3) {
                movieMenu();
            }
             else if (choice == 4) {
                break;
            }
            else if (choice == 5) {
                boolean back = Logout();

                if (back) {
                    break; // EXIT adminMenu
                }
            }
                }
    }

    public void adminUserList() {
        System.out.println("\n--- REGISTERED USERS ---");
        users = dm.getUsers();  // Refresh users list
        for (User u : users) {
            System.out.println("- " + u.getUsername() + " (" + u.getRole() + ")");
        }
    }
}