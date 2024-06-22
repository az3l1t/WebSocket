package net.az3l1t.websockets.chatroom.ChatRoomMVC;

import net.az3l1t.websockets.chatroom.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ChatRoomRepository extends MongoRepository<ChatRoom,String> {
    Optional<String> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
