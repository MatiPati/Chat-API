package pl.azurix.user;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(unique = true)
    private String login;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;


    public User() {
    }

    public User(String login, String password, String email) {
        this.login = login;
        this.email = email;
        this.password = password;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
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