package com.usm.WebRent.service.impl;

import com.usm.WebRent.entity.Location;
import com.usm.WebRent.repository.LocationRepository;
import com.usm.WebRent.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location findById(Long id) {
        return locationRepository.findById(id).orElseThrow(()-> new RuntimeException("Location with id:" + id + "doesn't exists"));
    }

    @Override
    public Location update(Long id, Location locationDetails) {
        Location location = findById(id);

        location.setAddress(locationDetails.getAddress());
        location.setCity(locationDetails.getCity());
        location.setPhone(locationDetails.getPhone());
        location.setWorkingHours(locationDetails.getWorkingHours());

        return locationRepository.save(location);
    }

    @Override
    public void deleteById(Long id) {
        locationRepository.deleteById(id);
    }
}
