package com.example.demo.chat;

import com.example.demo.chat.dto.ChatRoomRequestDto;
import com.example.demo.chat.dto.ChatRoomResponseDto;
import com.example.demo.chat.entity.Chat;
import com.example.demo.chat.entity.ChatRoom;
import com.example.demo.dto.MessageResponseDto;
import com.example.demo.item.entity.Item;
import com.example.demo.item.repository.ItemRepository;
import com.example.demo.member.entity.Member;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Service
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;
    private final ItemRepository itemRepository;

    private Map<String, ChatRoom> chatRoomMap;

    @PostConstruct
    private void init() {
        chatRoomMap = new LinkedHashMap<>();
    }

    // 채팅방 생성 - 아이템 상세 페이지 -> 채팅하기 버튼 누르면 실행
    public ResponseEntity<MessageResponseDto> createChatRoom(Long itemId, Member member) {
        Item item = itemRepository.findItemById(itemId);
        ChatRoom chatRoom = new ChatRoom(item, member);

        chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
        chatRoomRepository.save(chatRoom);

        MessageResponseDto msg = new MessageResponseDto("채팅방이 생성되었습니다.", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

    // 채팅방 상세 조회
    public ChatRoomResponseDto getChatRoomDetails(String id, Member member) {
        ChatRoom chatRoom = chatRoomRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 채팅방은 존재하지 않습니다.")
        );

        Item item = chatRoom.getItem();

        return new ChatRoomResponseDto(chatRoom, item, member);
    }

    // 유저별 전체 채팅방 조회
    public List<ChatRoomResponseDto> getAllChatRooms(Long id) {
        List<ChatRoomResponseDto> chatRoomList = chatRoomRepository.findAllBySellerIdOrConsumerId(id, id).stream().map(ChatRoomResponseDto::new).toList();
        return chatRoomList;
    }
}
