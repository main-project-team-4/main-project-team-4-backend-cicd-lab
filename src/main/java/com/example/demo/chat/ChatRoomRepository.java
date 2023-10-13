package com.example.demo.chat;

import com.example.demo.chat.entity.ChatRoom;
import com.example.demo.item.entity.Item;
import com.example.demo.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, String> {
    // Optional<ChatRoom> findChatRoomById(Long id);
    Optional<ChatRoom> findById(Long id);
    List<ChatRoom> findAllBySellerIdOrConsumerId(Long id_1, Long id_2);

    Optional<Item> findItemByRoomId(String id);
}
