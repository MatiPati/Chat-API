package pl.azurix.RoomUser;

import org.springframework.data.repository.CrudRepository;
import pl.azurix.room.Room;

import java.util.List;

public interface RoomUserRepository extends CrudRepository<RoomUser, Long> {
    List<RoomUser> findByRoom(Room room);
}
