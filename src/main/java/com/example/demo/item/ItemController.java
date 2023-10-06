package com.example.demo.item;

import com.example.demo.dto.MessageResponseDto;
import com.example.demo.member.Member;
import com.example.demo.security.UserDetailsImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

//    @Secured("ROLE_USER")
    @PostMapping
    public ResponseEntity<MessageResponseDto> createItem(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @Valid @RequestParam("image") MultipartFile image,
            @Valid @RequestParam("name") String name,
            @Valid @RequestParam("price") int price,
            @Valid @RequestParam("comment") String comment
            ) throws IOException {
        Member member = userDetails.getMember();
        return itemService.createItem(member, image, name, price, comment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponseDto> updateItem(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable Long id,
            @Valid @RequestParam("image") MultipartFile newFile,
            @Valid @RequestParam("name") String name,
            @Valid @RequestParam("price") int price,
            @Valid @RequestParam("comment") String comment
            ) throws IOException {
        Member member = userDetails.getMember();
        return itemService.updateItem(member, id, newFile, name, price, comment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDto> deleteItem(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable Long id
    ) {
        Member member = userDetails.getMember();
        return itemService.deleteItem(member, id);
    }

    @GetMapping
    public ResponseEntity<List<ItemSearchResponseDto>> searchItem(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Long category,
            @RequestParam(defaultValue = "2") Integer layer
    ) {
        return itemService.searchItem(keyword, category, layer);
    }

}
