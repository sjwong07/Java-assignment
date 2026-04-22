import java.io.Serializable;

class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private int role;

    public User(String username, String password, int role) {

        
        if (username == null || password == null) {
            throw new IllegalArgumentException("User fields cannot be null");
        }
        
        if (role != 1 && role != 2) {
        throw new IllegalArgumentException("Invalid role");
        }
        
        this.username = username;
        this.password = password;
        this.role = role;
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
