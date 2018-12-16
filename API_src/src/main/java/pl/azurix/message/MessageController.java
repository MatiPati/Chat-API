package pl.azurix.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;


@RestController
@RequestMapping("/room{room}")
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping("/new")
    @ResponseBody
    public String newMessage(@PathVariable final Long room  , @RequestParam Long sender_id, @RequestParam String message) {
        Message msg=new Message(room, sender_id, message);
        messageRepository.save(msg);
        return message;
    }

    @RequestMapping
    @ResponseBody
    public Iterable<String> getMessages(@PathVariable final Long room){ // @RequestParam Long amount
        return messageRepository.getMessages(room);
    }

}