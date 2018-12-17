package pl.azurix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class App {

    @CrossOrigin(origins = "*")
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}