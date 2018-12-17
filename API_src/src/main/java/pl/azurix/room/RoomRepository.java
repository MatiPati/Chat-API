package pl.azurix.room;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, Long> {
    @Query("SELECT t.id FROM Room t WHERE t.name=:name")
    Optional<Long> getIdFromName(@Param("name")String name);
}
