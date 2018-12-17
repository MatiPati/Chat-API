package pl.azurix.message;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Pageable;


public interface MessageRepository extends CrudRepository<Message, Long> {
    Page<Message> findByRoomId(Long roomId, Pageable pageable);
}
