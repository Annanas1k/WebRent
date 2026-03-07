package com.usm.WebRent.service;

import com.usm.WebRent.entity.Car;
import com.usm.WebRent.entity.Location;

import java.util.List;

public interface LocationService {
    Location save(Location location);
    List<Location> findAll();
    Location findById(Long id);
    Location update(Long id, Location car);
    void deleteById(Long id);
}
