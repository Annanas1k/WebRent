package com.usm.WebRent.service;

import com.usm.WebRent.entity.Location;
import com.usm.WebRent.entity.Rental;

import java.util.List;

public interface RentalService {
    Rental save(Rental rental);
    List<Rental> findAll();
    Rental findById(Long id);
    Rental update(Long id, Rental rental);
    void deleteById(Long id);
}
