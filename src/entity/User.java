package entity;

/**
 * @author a1399
 */
public class User {
    String username;
    String password;
    Boolean type;
    String email;

    public User() {
    }

    public User(String username, String password, Boolean type, String email) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
