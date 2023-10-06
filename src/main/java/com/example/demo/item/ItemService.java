package com.example.demo.item;

import com.example.demo.dto.MessageResponseDto;
import com.example.demo.member.Member;
import com.example.demo.shop.entity.Shop;
import com.example.demo.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ShopRepository shopRepository;
    private final S3Uploader s3Uploader;

    public ResponseEntity<MessageResponseDto> createItem(Member member, MultipartFile image, String name, int price, String comment) throws IOException {
        Shop shop = shopRepository.findById(member.getShop().getId()).orElseThrow(
                () -> new IllegalArgumentException("상점을 찾을 수 없습니다"));

        if(!shop.getMember().getId().equals(member.getId())) {
            throw new IllegalArgumentException("해당 상점의 주인만 물건 등록이 가능합니다.");
        }

        // 이미지 S3에 업로드 및 URL 가져오기
        String storedFileName = s3Uploader.upload(image, "images");
        URL imageUrl = new URL(storedFileName);

        itemRepository.save(new Item(name, price, comment, imageUrl, shop));

        MessageResponseDto msg = new MessageResponseDto("상품이 등록되었습니다.", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(msg);

    }

    @Transactional
    public ResponseEntity<MessageResponseDto> updateItem(Member member, Long id, MultipartFile newFile, String name, int price, String comment) throws IOException {
        Item item = findItem(id);
        Shop shop = item.getShop();

        // 상품을 올린 유저와 수정하려는 유저가 다를 경우
        if(!shop.getMember().getId().equals(member.getId())) {
            throw new IllegalArgumentException("해당 상품을 올린 유저만 상품을 수정 할 수 있습니다.");
        }

        String oldFileUrl = item.getImage().getPath().substring(1);
        String updatedImageUrl = s3Uploader.updateFile(newFile, oldFileUrl, "images");
        URL updatedImageUrlObject = new URL(updatedImageUrl);
        item.update(updatedImageUrlObject, name, price, comment); // Item 엔터티 업데이트

        MessageResponseDto msg = new MessageResponseDto("상품이 수정되었습니다.", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(msg);

    }


    private Item findItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 상품은 존재하지 않습니다."));
    }

    public ResponseEntity<MessageResponseDto> deleteItem(Member member, Long id) {
        Item item = findItem(id);
        Shop shop = item.getShop();

        // 상품을 올린 유저와 삭제하려는 유저가 다를 경우
        if(!shop.getMember().getId().equals(member.getId())) {
            throw new IllegalArgumentException("해당 상품을 올린 유저만 상품을 수정 할 수 있습니다.");
        }

        String filePathInS3 = item.getImage().getPath().substring(1);
        s3Uploader.deleteFile(filePathInS3);
        itemRepository.delete(item);

        MessageResponseDto msg = new MessageResponseDto("상품이 삭제되었습니다.", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

    public ResponseEntity<List<ItemSearchResponseDto>> searchItem(
            String keyword, Long category, Integer layer
    ) {
        List<ItemSearchResponseDto> dtoList = itemRepository.searchBy(keyword, category, layer).stream()
                .map(ItemSearchResponseDto::new)
                .toList();
        return ResponseEntity.ok(dtoList);
    }
}
