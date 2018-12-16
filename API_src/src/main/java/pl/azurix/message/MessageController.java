package pl.azurix.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/room{room}")
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping
    @ResponseBody
    public String newMessage(@PathVariable final Long room  , @RequestParam Long sender_id, @RequestParam String message) {
        Message msg=new Message(room, sender_id, message);
        messageRepository.save(msg);
        return message;
    }

}