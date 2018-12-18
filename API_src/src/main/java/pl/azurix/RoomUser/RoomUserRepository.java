package pl.azurix.RoomUser;

import org.springframework.data.repository.CrudRepository;
import pl.azurix.room.Room;

import java.util.List;
import java.util.Optional;

public interface RoomUserRepository extends CrudRepository<RoomUser, Long> {
    Optional<List>  findByRoom(Room room);
}
