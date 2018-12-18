package pl.azurix.message;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import pl.azurix.room.Room;
import pl.azurix.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "messages")
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @NotNull
    @JoinColumn(name = "room_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Room room;

    @JsonIgnore
    @NotNull
    @JoinColumn(name = "sender_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User senderId;

    @NotNull
    private String message;

    public Message(){}
    public Message(Room room, @NotNull User senderId, @NotNull String message) {
        this.room = room;
        this.senderId = senderId;
        this.message = message;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSenderId(User senderId) {
        this.senderId = senderId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public User getSenderId() {
        return senderId;
    }

    public String getMessage() {
        return message;
    }
}
