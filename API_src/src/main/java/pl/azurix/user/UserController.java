package pl.azurix.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 *  HOW TO USE:
 *
 * -create new user
 * /register?email=<email>
 *     <creatorId> Long
 *     <name> String
 *     return: "200" room has been created
 *     ResourceNotFoundException if room hasn't been created
 *
 * -login
 * /login?login=<login>&password=<password>
 *     <login> String
 *     <password> String
 *     return: Object User
 */

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @CrossOrigin(origins = "*")
    @RequestMapping("/login")
    public User login(@RequestParam String login, @RequestParam String password){
        return userRepository.findByLoginAndPassword(login,password).get();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/register")
    public String newUser(@RequestParam String email, @RequestParam String login, @RequestParam String password){
        User user=new User(email,login,password);
        userRepository.save(user);
        return "200";
    }
}
