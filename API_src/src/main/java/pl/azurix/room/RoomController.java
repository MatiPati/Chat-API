package pl.azurix.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.azurix.user.UserRepository;

import java.util.Optional;

@RestController
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/room/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String newRoom(@RequestParam Integer creator_id, @RequestParam String name){
        Room room=new Room(userRepository.findById(creator_id).get(),name);
        roomRepository.save(room);
        return "hiho";
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/rooms")
    public Iterable<Room> getAllRooms(){
        return roomRepository.findAll();
    }

}
/*
    //update example
    public Post updatePost(@PathVariable Long postId, @Valid @RequestBody Post postRequest) {
        return postRepository.findById(postId).map(post -> {
            post.setTitle(postRequest.getTitle());
            post.setDescription(postRequest.getDescription());
            post.setContent(postRequest.getContent());
            return postRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

    //delete example
     public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        return postRepository.findById(postId).map(post -> {
            postRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }
 */