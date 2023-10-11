package com.example.demo.item.controller;


import com.example.demo.dto.MessageResponseDto;
import com.example.demo.item.dto.ItemResponseDto;
import com.example.demo.item.dto.ItemSearchResponseDto;
import com.example.demo.item.dto.itemRequestDto;
import com.example.demo.security.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Tag(
        name = "상품 API",
        description = "상품 API"
)
public interface ItemDocs {
    @Operation(
            summary = "상품 생성 API",
            description = """
                    상품 생성 API
                    """
    )
    @ApiResponse(
            responseCode = "200",
            description = "정상 작동",
            content = @io.swagger.v3.oas.annotations.media.Content(
                    mediaType = "application/json",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ItemResponseDto.class)
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "'~~'번 상품은 존재하지 않음.",
            content = @io.swagger.v3.oas.annotations.media.Content(
                    mediaType = "application/json",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ErrorResponse.class)
            )
    )
    @ApiResponse(
            responseCode = "500",
            description = "서버 에러",
            content = @io.swagger.v3.oas.annotations.media.Content(
                    mediaType = "application/json",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ErrorResponse.class)
            )
    )


    ResponseEntity<MessageResponseDto> createItem(
            @Parameter(
                    description = "상품 생성 시, 필요한 정보들.",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = itemRequestDto.class)
            )
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @Valid @RequestParam("main_image") MultipartFile main_image,
            @Valid @RequestParam("sub_image") List<MultipartFile> sub_images,
            @RequestPart(value = "requestDto", required = false) itemRequestDto requestDto
    ) throws IOException;

    @Operation(
            summary = "상품 수정 API",
            description = """
                    상품 수정 API
                    """
    )
    @ApiResponse(
            responseCode = "200",
            description = "정상 작동",
            content = @io.swagger.v3.oas.annotations.media.Content(
                    mediaType = "application/json",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ItemResponseDto.class)
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "'~~'번 상품은 존재하지 않음.",
            content = @io.swagger.v3.oas.annotations.media.Content(
                    mediaType = "application/json",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ErrorResponse.class)
            )
    )
    @ApiResponse(
            responseCode = "500",
            description = "서버 에러",
            content = @io.swagger.v3.oas.annotations.media.Content(
                    mediaType = "application/json",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ErrorResponse.class)
            )
    )
    ResponseEntity<MessageResponseDto> updateItem(
            @Parameter(
                    description = "상품 수정 시, 필요한 정보들.",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = itemRequestDto.class)
            )
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable Long id,
            @Valid @RequestParam("main_image") MultipartFile new_mainImage,
            @Valid @RequestParam("sub_image") List<MultipartFile> new_subImages,
            @RequestPart(value = "requestDto", required = false) itemRequestDto requestDto
    ) throws IOException;

    @Operation(
            summary = "상품 삭제 API",
            description = """
                    상품 삭제 API
                    """
    )
    @ApiResponse(
            responseCode = "200",
            description = "정상 작동",
            content = @io.swagger.v3.oas.annotations.media.Content(
                    mediaType = "application/json",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation =  ErrorResponse.class)
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "'~~'번 상품은 존재하지 않음.",
            content = @io.swagger.v3.oas.annotations.media.Content(
                    mediaType = "application/json",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ErrorResponse.class)
            )
    )
    @ApiResponse(
            responseCode = "500",
            description = "서버 에러",
            content = @io.swagger.v3.oas.annotations.media.Content(
                    mediaType = "application/json",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ErrorResponse.class)
            )
    )
    ResponseEntity<MessageResponseDto> deleteItem(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @PathVariable Long id
    );

    @Operation(
            summary = "상품 조회 API",
            description = """
                    상품 조회 API
                    """
    )
    @ApiResponse(
            responseCode = "200",
            description = "정상 작동",
            content = @io.swagger.v3.oas.annotations.media.Content(
                    mediaType = "application/json",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ItemResponseDto.class)
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "'~~'번 상품은 존재하지 않음.",
            content = @io.swagger.v3.oas.annotations.media.Content(
                    mediaType = "application/json",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ErrorResponse.class)
            )
    )
    @ApiResponse(
            responseCode = "500",
            description = "서버 에러",
            content = @io.swagger.v3.oas.annotations.media.Content(
                    mediaType = "application/json",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ErrorResponse.class)
            )
    )
    ItemResponseDto showItem(
            @Parameter(
                    description = "상품 조회 시, 필요한 정보들.",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ItemResponseDto.class)
            )
            @PathVariable Long item_id
    );

   @Operation(
            summary = "상품 검색 API",
            description = """
                    상품 검색 API
                    """
    )
    @ApiResponse(
            responseCode = "200",
            description = "정상 작동",
            content = @io.swagger.v3.oas.annotations.media.Content(
                    mediaType = "application/json",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ItemSearchResponseDto.class)
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "'~~'번 상품은 존재하지 않음.",
            content = @io.swagger.v3.oas.annotations.media.Content(
                    mediaType = "application/json",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ErrorResponse.class)
            )
    )
   @ApiResponse(
            responseCode = "500",
            description = "서버 에러",
            content = @io.swagger.v3.oas.annotations.media.Content(
                    mediaType = "application/json",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ErrorResponse.class)
            )
    )
    ResponseEntity<List<ItemSearchResponseDto>> searchItem(
            @RequestParam(required = false) String keyword
    );
}
