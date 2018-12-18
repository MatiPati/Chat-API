package pl.azurix.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT t.id FROM User t WHERE t.login=:login AND t.password=:password")
    Long login(@Param("login") String login, @Param("password") String password);
}