package test;

import javax.persistence.*;

@Table(name = "users")
@Entity
public class User {


    private String id;
    @Id
    private String login;
    private String email;
    private String password;


    public User() {
    }

    public User(String login, String password, String email) {
        this.login = login;
        this.email = email;
        this.password = password;

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}