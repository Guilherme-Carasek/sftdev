package Domain;

public class User {
    private String tipoConta;
    private String userName;
    private String password;

    public User(String tipoConta, String userName, String password) {
        this.tipoConta = tipoConta;
        this.userName = userName;
        this.password = password;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
