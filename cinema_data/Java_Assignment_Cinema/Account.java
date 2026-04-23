import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

class Account extends User {
    DataManager dm = new DataManager();
    ArrayList<User> users;
    ViewSchedule vs; 
    Scanner scan = new Scanner(System.in); 

    // Default constructor for utility use in Cinema.java
    public Account() {
        super("temp", "temp", 1);
        dm.loadData();
        this.users = dm.getUsers();
        vs = new ViewSchedule(this); 
        initializeData();
        
    }

    public Account(String user, String pass, int role) {
        super(user, pass, role);
        dm.loadData();
        this.users = dm.getUsers();
        
    }

    public void initializeData() {
        if (users.isEmpty()) {
            users.add(new User("admin", "Admin@123", 1));
            
            dm.saveData(); 
        }
    }

    public boolean isValidPassword(String pass) {
        String regex = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).+$";
        return Pattern.compile(regex).matcher(pass).matches();
    }

    
    
    public boolean handleLogin() {
        String rolename = "";
        System.out.println("What is your role?: " + "\n1.Admin" + "\n2.Staff" +"\n3.Member");
        int roleSelection = scan.nextInt();
        scan.nextLine();
        System.out.print("\nUsername: ");
        String uname = scan.nextLine();
        System.out.print("Password: ");
        String pass = scan.nextLine();

        for (User u : users) {

        if(roleSelection == 1){
           rolename = "Admin";
        }

        else if(u.getRole() == 2){
            rolename = "Staff";
        }

        else if(u.getRole() == 3){
            rolename = "Member";
        }

        if (u.getUsername().equals(uname) && u.getPassword().equals(pass)) {
                System.out.println("Welcome, " + uname + " [" + "Role: " + rolename + "]");
        }
        vs.setCurrentUser(u);

        if(roleSelection == 1){
          vs.adminMenu();
    }
        else if(roleSelection == 2){
            vs.movieMenu();
    }
    
        return true;
            }
        
       
        System.out.println("Error: Invalid login credentials.");
        
        return false;
    }

    public void handleRegister(boolean isAdminCreating) {  
    int role;
    
    if (isAdminCreating) {
        
        System.out.println("Select Role (1. Admin / 2. Staff):");
        role = scan.nextInt();
        scan.nextLine();
    } else {
        role = 3;
    }
    
    String uname;
    boolean exists;
    
    do {
        System.out.println("\n--- REGISTER NEW ACCOUNT(Member) ---");
        System.out.print("Enter New Username: ");
        uname = scan.nextLine();
        exists = false;

        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(uname)) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("Username already exists! Please try again.");
        }
    } while (exists);

        String pass = "";
        // FIXED: Loop allows user to retry until password requirements are met
        while (true) {
            System.out.print("Enter Password: ");
            pass = scan.nextLine();

            if (isValidPassword(pass)) {
                break; // Exit loop if password is valid
            } else {
                System.out.println("\n--- PASSWORD REJECTED ---");
                System.out.println("Must include: Alphabet, Number, and Special Character.");
                System.out.println("Please try again.\n");
            }
        }
         if (role == 1) {
            System.out.print("Enter Admin Special Key: ");
            String key = scan.nextLine();
            if (!key.equals("Symx2288j")) {
                System.out.println("Error: Invalid Admin Special Key.");
                
            }
        }
    
        users.add(new User(uname, pass, role));
        dm.saveData();
        System.out.println("Success: " + role + " account '" + uname + "' created.");
        
        if (isAdminCreating) {
            if(role == 1){
        vs.adminMenu();
    }
      else if(role == 2){ 
         vs.movieMenu();
      }

    }
    }
    
    }



