package net.az3l1t.websockets.chat.chatMessageMVC;

import java.util.List;
import net.az3l1t.websockets.chat.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessageRepository extends MongoRepository<ChatMessage,String> {
    List<ChatMessage> findByChatId(String s);
}
