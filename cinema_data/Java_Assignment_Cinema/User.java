import java.io.Serializable;

class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private int role;
    private double tngBalance;
    private double boostBalance;
    private double shopeePayBalance;
    
    // Constructor
    public User(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.tngBalance = 0.0;
        this.boostBalance = 0.0;
        this.shopeePayBalance = 0.0;
    
        
        if (username == null || password == null) {
            throw new IllegalArgumentException("User fields cannot be null");
        }

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password; 
    }

    public int getRole() {
        return role;
    }

    

    
    @Override
    public String toString() {
        return "User{username='" + username + "', role='" + role + "'}";
    }
}
