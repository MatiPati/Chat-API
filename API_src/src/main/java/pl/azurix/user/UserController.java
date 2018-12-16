package pl.azurix.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired // This means to get the bean called userRepository
    private UserRepository usersRepository;

    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestParam String login, @RequestParam String password, @RequestParam String email) {
        User usr = new User(login, password, email);
        usersRepository.save(usr);
        return "done";
    }
    @RequestMapping("/login")
    @ResponseBody
    public Optional<User> login(@RequestParam String login, @RequestParam String password) {
        return usersRepository.findById(usersRepository.login(login, password));
    }

    @RequestMapping("/users")
    @ResponseBody
    public Iterable<User> allusers(){
        return usersRepository.findAll();
    }

    @RequestMapping("/users/{id}")
    @ResponseBody
    public Optional<User> iduser(@PathVariable final Integer id){
        return usersRepository.findById(id);
    }
}