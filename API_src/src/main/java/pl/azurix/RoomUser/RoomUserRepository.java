package pl.azurix.RoomUser;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RoomUserRepository extends CrudRepository<RoomUser, Long> {
    @Query("SELECT t.userId FROM RoomUser t WHERE roomId=:roomId")
    Optional<List<Long>> selectWithRoomId(@Param("roomId") Long roomId);
}
