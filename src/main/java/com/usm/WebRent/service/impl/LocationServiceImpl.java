package com.usm.WebRent.service.impl;

import com.usm.WebRent.entity.Location;
import com.usm.WebRent.repository.LocationRepository;
import com.usm.WebRent.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Override
    public Location save(Location location) {return locationRepository.save(location);}
}
