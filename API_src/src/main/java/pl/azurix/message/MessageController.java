package pl.azurix.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.azurix.room.RoomRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import pl.azurix.user.UserRepository;

import java.util.*;

/*
 *  HOW TO USE:
 *
 * -create new message
 * /room/<roomId>/message?senderId=<senderId>&message=<message>
 *     <roomId> Long
 *     <senderId> Integer
 *     <message> String
 *     return: "200" if message has been created
 *     ResourceNotFoundException if message hasn't been created
 *
 * -get messages from room
 * /room/<roomId>?requestCount=<requestCount>
 *     <roomId> Long
 *     <requestCount> Integer (default value= 0)    for val=0- first 10 messages, val=1- messages from 11 to 20, val=3- 21-30
 *     return:
 */

@RestController
public class MessageController {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "*")
    @RequestMapping("/room/{roomId}/message")
    @ResponseBody
    public String newMessage(@PathVariable(value = "roomId") Long roomId, @RequestParam Integer senderId, @RequestParam String message) {
        return roomRepository.findById(roomId).map(room -> {
            return userRepository.findById(senderId).map(user -> {
                Message msg=new Message(room,user,message);
                return "200";
            }).orElseThrow(()-> new ResourceNotFoundException("sender_id "+senderId+" not found"));
        }).orElseThrow(()-> new ResourceNotFoundException("room_id "+roomId+" not found"));
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/room/{roomId}")
    public List<Message> getMessages(@PathVariable("roomId") Long roomId,@RequestParam(value = "requestCount", defaultValue = "0") Integer requestCount){
        Pageable limit=PageRequest.of(requestCount,10);
        return messageRepository.findByRoomIdOrderByIdDesc(roomId, limit);

    }
}
/*
 * IN THE FUTURE:
 * -edit message?
 * -delete message?
 *
 */