package com.example.demo.follow.controller;


import com.example.demo.follow.dto.FollowMemberResponseDto;
import com.example.demo.security.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(
        name = "팔로우 API",
        description = "팔로우 API"
)
public interface FollowDocs {

    @Operation(
            summary = "팔로우 하기",
            description = """
                    팔로우 하기
                    """
    )
    @ApiResponse(
            responseCode = "200",
            description = "정상 작동",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = FollowMemberResponseDto.class)
            )//응답받을 데이터 타입
    )
    @ApiResponse(
            responseCode = "404",
            description = "'~~'번 팔로우는 존재하지 않음.",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class)
            ))
    @ApiResponse(
            responseCode = "500",
            description = "서버 에러",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class)
            )
    )
     ResponseEntity<Void> doShopFollow(
            @PathVariable Long shopId,
            @AuthenticationPrincipal UserDetailsImpl principal
    );

    @Operation(
            summary = "팔로워 목록 조회",
            description = """
                    팔로워 목록 조회
                    """
    )
    @ApiResponse(
            responseCode = "200",
            description = "정상 작동",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = FollowMemberResponseDto.class)
            )//응답받을 데이터 타입
    )
    @ApiResponse(
            responseCode = "404",
            description = "'~~'번 팔로워는 존재하지 않음.",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class)
            ))
    @ApiResponse(
            responseCode = "500",
            description = "서버 에러",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class)
            )
    )
    ResponseEntity<List<FollowMemberResponseDto>> readFollowersByMemberId(
            @PathVariable Long memberId
    );

    @Operation(
            summary = "팔로잉 목록 조회",
            description = """
                    팔로잉 목록 조회
                    """
    )
    @ApiResponse(
            responseCode = "200",
            description = "정상 작동",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = FollowMemberResponseDto.class)
            )//응답받을 데이터 타입
    )
    @ApiResponse(
            responseCode = "404",
            description = "'~~'번 팔로잉는 존재하지 않음.",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class)
            ))
    @ApiResponse(
            responseCode = "500",
            description = "서버 에러",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class)
            )
    )
    ResponseEntity<List<FollowMemberResponseDto>> readFollowingsByMemberId(
            @PathVariable Long memberId
    );

    @Operation(
            summary = "내 팔로워 목록 조회",
            description = """
                    내 팔로워 목록 조회
                    """
    )
    @ApiResponse(
            responseCode = "200",
            description = "정상 작동",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = FollowMemberResponseDto.class)
            )//응답받을 데이터 타입
    )
    @ApiResponse(
            responseCode = "404",
            description = "'~~'번 팔로워는 존재하지 않음.",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class)
            ))
    @ApiResponse(
            responseCode = "500",
            description = "서버 에러",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class)
            )
    )
    ResponseEntity<List<FollowMemberResponseDto>> readFollowerListInMyPage(
            @AuthenticationPrincipal UserDetailsImpl principal
    );
}
