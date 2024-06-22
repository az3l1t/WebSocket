package net.az3l1t.websockets.user.UserMVC;

import net.az3l1t.websockets.user.Status;
import net.az3l1t.websockets.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {
    List<User> findAllByStatus(Status status);
}
