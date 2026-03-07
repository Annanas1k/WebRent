package com.usm.WebRent.service.impl;

import com.usm.WebRent.entity.Car;
import com.usm.WebRent.entity.Location;
import com.usm.WebRent.entity.Rental;
import com.usm.WebRent.entity.Users;
import com.usm.WebRent.entity.enums.RentalStatus;
import com.usm.WebRent.repository.RentalRepository;
import com.usm.WebRent.service.RentalService;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {
    private final RentalRepository rentalRepository;

    @Override
    public Rental save(Rental rental) {
        return rentalRepository.save(rental);
    }

    @Override
    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }

    @Override
    public Rental findById(Long id) {
        return rentalRepository.findById(id).orElseThrow(()-> new RuntimeException("Rental with id:" + id + "doesn't exist"));
    }

    @Override
    public Rental update(Long id, Rental rentalDetails) {
        Rental rental = findById(id);

        rental.setCar(rentalDetails.getCar());
        rental.setStatus(rentalDetails.getStatus());
        rental.setCreatedAt(rentalDetails.getCreatedAt());
        rental.setUser(rentalDetails.getUser());
        rental.setEndDate(rentalDetails.getEndDate());
        rental.setPickupLocation(rentalDetails.getPickupLocation());
        rental.setStartDate(rentalDetails.getStartDate());
        rental.setTotalPrice(rentalDetails.getTotalPrice());

        return rentalRepository.save(rental);
    }

    @Override
    public void deleteById(Long id) {
        rentalRepository.deleteById(id);
    }
}
