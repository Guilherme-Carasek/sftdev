package Domain;

public class User {
    private String userType;
    private String userName;
    private String password;

    public User(String userType, String userName, String password) {
        this.userType = userType;
        this.userName = userName;
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
