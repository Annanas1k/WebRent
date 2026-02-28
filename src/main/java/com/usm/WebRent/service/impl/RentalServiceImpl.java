package com.usm.WebRent.service.impl;

import com.usm.WebRent.entity.Rental;
import com.usm.WebRent.repository.RentalRepository;
import com.usm.WebRent.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {
    private final RentalRepository rentalRepository;

    @Override
    public Rental save(Rental rental) {return rentalRepository.save(rental);}
}
