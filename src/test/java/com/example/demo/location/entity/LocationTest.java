package com.example.demo.location.entity;

import com.example.demo.location.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:.env")
class LocationTest {
    @Autowired
    private LocationRepository locationRepository;

    @Transactional
    @Test
    @DisplayName("[정상 작동] Location 엔티티 영속 시, LocationListener 작동 여부 확인.")
    void loadCoordinates() {
        // given
        String address = "카카오 본사";
        Location entity = new Location();
        entity.setName(address);

        // when
        Location saved = locationRepository.save(entity);

        // then
        log.info(saved.toString());
        assertTrue(saved.hasCoordinates());
    }

    @Transactional
    @Test
    @DisplayName("[비정상 작동] Location 엔티티 영속 시, 잘못된 주소를 기입하면 오류 발생.")
    void loadCoordinatesOccurWhenWrongAddress() {
        // given
        String address = "절대로 존재할 수 없는 주소 문자열 조합";
        Location entity = new Location();
        entity.setName(address);

        // when
        Executable func = () -> locationRepository.save(entity);

        // then
        assertThrows(InvalidDataAccessApiUsageException.class, func);
    }
}