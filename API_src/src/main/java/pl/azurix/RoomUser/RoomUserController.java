package pl.azurix.RoomUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import pl.azurix.room.Room;
import pl.azurix.room.RoomRepository;
import pl.azurix.user.User;
import pl.azurix.user.UserRepository;

import java.util.ArrayList;
import java.util.List;

/*
 *  HOW TO USE:
 *
 * -add new user to room
 * /room/<roomId>/add/user?userId=<userId>
 *     <roomId> Long
 *     <userId> Long
 *     return: "200" if user has been added
 *     ResourceNotFoundException if user hasn't been added
 *
 * -get all users from room   //doesn't work
 * /room/<roomId>/users
 *     <roomId> Long
 *     return: Optional<List> with all users
 */

@RestController
public class RoomUserController {
    @Autowired
    RoomUserRepository roomUserRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    UserRepository userRepository;

    @CrossOrigin(origins = "*")
    @RequestMapping("/room/{roomId}/add/user")
    @ResponseBody
    String addNewUser(@RequestParam Long userId, @PathVariable Long roomId) {
        return roomRepository.findById(roomId).map(room -> {
            return userRepository.findById(userId).map(user -> {
                RoomUser rusr = new RoomUser(user, room);
                roomUserRepository.save(rusr);
                return "200";
            }).orElseThrow(() -> new ResourceNotFoundException("user id " + userId + " not found"));
        }).orElseThrow(() -> new ResourceNotFoundException("room_id " + roomId + " not found"));
    }


    @RequestMapping("/room/{roomId}/users")
    List<User> selectUsers(@PathVariable Long roomId) {
        List <RoomUser> list=roomUserRepository.findByRoom(roomRepository.findById(roomId).get());
        List<User> rooms= new ArrayList<>();
        list.forEach(roomUser -> {
            rooms.add(roomUser.getUser());
        });
        return rooms;
    }

}

