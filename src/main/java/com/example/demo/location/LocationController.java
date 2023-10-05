package com.example.demo.location;


import com.example.demo.dto.MessageResponseDto;
import com.example.demo.security.UserDetailsImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LocationController {
    private final LocationService locationService;

    @PostMapping("/locations")
    public ResponseEntity<MessageResponseDto> createLocation(@RequestBody @Valid LocationRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return locationService.createLocation(requestDto, userDetails.getMember());
    }
    @DeleteMapping("/locations/{location_id}")
    public ResponseEntity<MessageResponseDto> deleteLocation(@PathVariable Long location_id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return locationService.deleteLocation(location_id, userDetails.getMember());
    }
}




