package com.example.demo.location.listener;

import com.example.demo.location.dto.CoordinateVo;
import com.example.demo.location.entity.Location;
import com.example.demo.location.service.LocationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.persistence.PrePersist;
import org.springframework.util.StringUtils;

public class LocationListener {
    private static final LazyInjector<LocationService> locationService = new LazyInjector<>(LocationService.class);

    @PrePersist
    public void loadCoordinates(Location entity) throws JsonProcessingException {
        if(!StringUtils.hasText(entity.getName())) return;
        if(entity.hasCoordinates()) return;
        LocationService service = locationService.getBean();

        CoordinateVo coordinate = service.getCoordinateFromAddress(entity.getName());
        entity.setCoordinates(coordinate);
    }
}
