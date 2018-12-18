package pl.azurix.room;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import pl.azurix.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "rooms")
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "creator_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User creator;

    @NotNull
    @Column(unique = true)
    private String name;

    Room() {
    }

    Room(User creator, String name) {
        this.creator = creator;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatorId(User creatorId) {
        this.creator = creatorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public User getCreatorId() {
        return creator;
    }

    public String getName() {
        return name;
    }
}
