package pl.azurix.RoomUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room{room}")
public class RoomUserController {

    @Autowired
    RoomUserRepository roomUserRepository;

    @RequestMapping("/add")
    @ResponseBody
    String addNewUser(@RequestParam Long user_id, @PathVariable final Long room) {
        RoomUser usr = new RoomUser(user_id, room);
        roomUserRepository.save(usr);
        return "done";
    }
}
