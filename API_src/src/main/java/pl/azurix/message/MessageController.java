package pl.azurix.message;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import pl.azurix.room.RoomRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.*;


@RestController
public class MessageController {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping("/room/{roomId}/message")
    @ResponseBody
    public String newMessage(@PathVariable(value = "roomId") Long roomId, @RequestParam Long sender_id, @RequestParam String message) {
        return roomRepository.findById(roomId).map(room -> {
            Message msg=new Message(room,sender_id,message);
            return "200";
        }).orElseThrow(()-> new ResourceNotFoundException("room_id "+roomId+" not found"));
    }

    /*
    @RequestMapping("/room/{roomId}")
    @ResponseBody
    public List<Object> getMessages(@RequestParam String action, @RequestParam Long room, @RequestParam(value = "limit", defaultValue = "15") int limit) {
        if(action.equals("get_messages")) {
            Page<Object> val = messageRepository.getMessages(room, PageRequest.of(0, limit));
            return val.getContent();
        } else return new ArrayList<Object>(Arrays.asList("error, no action"));
    }
    */


}