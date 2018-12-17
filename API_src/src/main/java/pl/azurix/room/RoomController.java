package pl.azurix.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping(value="/room/new", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String newRoom(@RequestBody Room room){
        roomRepository.save(room);
        return "hiho";
    }

    @RequestMapping("/rooms")
    public Iterable<Room> getAllRooms(){
        return roomRepository.findAll();
    }


    public Optional<Long> getRoomId(String room){
        return roomRepository.getIdFromName(room);
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