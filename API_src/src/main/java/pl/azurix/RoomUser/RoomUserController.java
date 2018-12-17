package pl.azurix.RoomUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/room/{room}")
public class RoomUserController {
    private EntityManager entityManager;
    @Autowired
    RoomUserRepository roomUserRepository;

    @RequestMapping("/add")
    @ResponseBody
    String addNewUser(@RequestParam Long user_id, @PathVariable Long room) {
        RoomUser usr = new RoomUser(user_id, room);
        roomUserRepository.save(usr);
        return "done";
    }

    @RequestMapping("/users")
    @ResponseBody
    Optional<List<Long>> selectUsers(@PathVariable Long room) {
        return roomUserRepository.selectWithRoomId(room);
    }

}
