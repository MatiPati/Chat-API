package pl.azurix.RoomUser;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Table(name = "room_users")
@Entity
public class RoomUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @Column(name = "user_id")
    @NotNull
    Long userId;

    //https://www.callicoder.com/hibernate-spring-boot-jpa-one-to-many-mapping-example/
    @Column(name = "room_id")
    @NotNull
    Long roomId;

    public RoomUser(Long userId, Long roomId) {
        this.userId = userId;
        this.roomId = roomId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getRoomId() {
        return roomId;
    }
}
