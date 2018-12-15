package test;

import javax.persistence.*;

@Entity
public class User {

    @Id
    private long id;
    //przy tworzeniu nowego musi pobrac najwyzsze id i dodac 1..
    
    private String login;
    private String email;
    private String password;


    public User(){}

    public User(String login, String password, String email) {
        this.login = login;
        this.email = email;
        this.password = password;

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

    public void setId(Integer id) {
        this.id = id;
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