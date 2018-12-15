package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired // This means to get the bean called userRepository
    private UserRepository usersRepository;

    @RequestMapping("/register")
    @ResponseBody
    public String register( String login, @RequestParam String password, @RequestParam String email) {
        User usr = new User( login, password, email);
        usersRepository.save(usr);
        return "done";
    }
}