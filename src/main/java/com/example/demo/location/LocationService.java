package com.example.demo.location;

import com.example.demo.dto.MessageResponseDto;
import com.example.demo.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;


    public ResponseEntity<MessageResponseDto> createLocation(LocationRequestDto requestDto, Member member) {
        Location location = new Location(requestDto, member);
        locationRepository.save(location);
        MessageResponseDto msg = new MessageResponseDto("위치 등록에 성공하였습니다.", 200);
        return ResponseEntity.status(200).body(msg);
    }

    public ResponseEntity<MessageResponseDto> deleteLocation(Long locationId, Member member) {
        Location location = locationRepository.findById(locationId).orElseThrow(
                () -> new IllegalArgumentException("해당 주소가 존재하지 않습니다.")
        );

        locationRepository.delete(location);
        MessageResponseDto msg = new MessageResponseDto("주소 삭제에 성공하였습니다.", 200);
        return ResponseEntity.status(200).body(msg);
    }
}
