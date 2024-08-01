package za.ac.cput.dto;
//This class handles login requests

public class AuthenticateUser {

    private String email;
    private String password;

    private AuthenticateUser(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
