package pl.azurix.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/register")
    public String newUser(@RequestParam String email, @RequestParam String login, @RequestParam String password){
        User user=new User(email,login,password);
        userRepository.save(user);
        return "200";
    }
}
