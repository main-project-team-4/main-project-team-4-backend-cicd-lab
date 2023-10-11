package com.example.demo.member.controller;


import com.example.demo.dto.MessageResponseDto;
import com.example.demo.member.dto.LoginRequestDto;
import com.example.demo.member.dto.MemberInfoRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Tag(
        name = "회원 API",
        description = "회원 API"
)
public interface MemberDocs {
    @Operation(
            summary = "회원 수정 API",
            description = """
                    회원 수정 API
                    """
    )
    @ApiResponse(
            responseCode = "200",
            description = "정상 작동"
    )
    @ApiResponse(
            responseCode = "404",
            description = "'~~'번 회원은 존재하지 않음.",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class)
            )
    )
    @ApiResponse(
            responseCode = "500",
            description = "서버 에러",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class)
            )
    )
    ResponseEntity<MessageResponseDto> updateMember(
            @Valid @RequestBody MemberInfoRequestDto request, @RequestHeader("Authorization") String token);


    @Operation(
            summary = "회원 탈퇴 API",
            description = """
                    회원 탈퇴 API
                    """
    )
    @ApiResponse(
            responseCode = "200",
            description = "정상 작동",
            content = @Content(
                    mediaType = MediaType.TEXT_PLAIN_VALUE
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "'~~'번 회원은 존재하지 않음.",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class)
            )
    )
    @ApiResponse(
            responseCode = "500",
            description = "서버 에러",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class)
            )
    )
    ResponseEntity<MessageResponseDto> deleteMember(@Valid @RequestBody LoginRequestDto request, @RequestHeader("Authorization") String token);


}
