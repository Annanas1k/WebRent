package com.usm.WebRent.service.impl;

import com.usm.WebRent.entity.Review;
import com.usm.WebRent.repository.ReviewRepository;
import com.usm.WebRent.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public Review save(Review review) {return reviewRepository.save(review);}
}
