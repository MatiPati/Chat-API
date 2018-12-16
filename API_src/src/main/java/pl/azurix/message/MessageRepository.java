package pl.azurix.message;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;

public interface MessageRepository extends CrudRepository<Message, Long> {
    @Query("SELECT t.senderId, t.message FROM Message t WHERE t.roomId=:roomId")
    Iterable<String> getMessages(@Param("roomId") Long roomId);
}
