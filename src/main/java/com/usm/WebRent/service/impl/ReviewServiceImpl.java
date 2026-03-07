package com.usm.WebRent.service.impl;

import com.usm.WebRent.entity.Car;
import com.usm.WebRent.entity.Review;
import com.usm.WebRent.entity.Users;
import com.usm.WebRent.entity.enums.ReviewRating;
import com.usm.WebRent.repository.ReviewRepository;
import com.usm.WebRent.service.ReviewService;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElseThrow(()-> new RuntimeException("Review with id:" + id + "doesn't exist"));
    }

    @Override
    public Review update(Long id, Review reviewDetails) {
        Review review = findById(id);

        review.setCar(reviewDetails.getCar());
        review.setUser(reviewDetails.getUser());
        review.setRating(reviewDetails.getRating());
        review.setComment(reviewDetails.getComment());
        review.setCreatedAt(reviewDetails.getCreatedAt());

        return reviewRepository.save(review);
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}
