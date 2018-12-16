package pl.azurix.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping("/room{room},{limit}")
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping("/new")
    @ResponseBody
    public String newMessage(@PathVariable final Long room, @RequestParam Long sender_id, @RequestParam String message) {
        Message msg = new Message(room, sender_id, message);
        messageRepository.save(msg);
        return message;
    }
    @RequestMapping
    @ResponseBody
    public List<Object> getMessages(@PathVariable final Long room, @PathVariable final int limit) {
        Page<Object> val= messageRepository.getMessages(room, PageRequest.of(0, limit));
        return val.getContent();
    }



}