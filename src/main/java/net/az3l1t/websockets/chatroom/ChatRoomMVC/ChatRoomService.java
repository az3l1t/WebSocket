package net.az3l1t.websockets.chatroom.ChatRoomMVC;

import net.az3l1t.websockets.chatroom.ChatRoom;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

    public Optional<String> getChatRoomId(
            String senderId,
            String recipientId,
            boolean createNewRoomIfNotExists
    ){
        Optional<String> chatId = chatRoomRepository.findBySenderIdAndRecipientId(senderId, recipientId);
        if (chatId.isPresent()) {
            return chatId;
        } else {
            if (createNewRoomIfNotExists) {
                return Optional.of(createChatId(senderId,recipientId));
            }
            return Optional.empty();
        }
    }

    private String createChatId(String senderId, String recipientId) {
        var newChatId = String.format("%s_%s",senderId,recipientId);
        ChatRoom senderRecipient = new ChatRoom(newChatId,senderId,recipientId);
        ChatRoom recipientSender = new ChatRoom(newChatId,recipientId,senderId);
        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);
        return newChatId;
    }
}
