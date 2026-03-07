package com.usm.WebRent.service;

import com.usm.WebRent.entity.Review;

import java.util.List;

public interface ReviewService {
    Review save(Review review);
    List<Review> findAll();
    Review findById(Long id);
    Review update(Long id, Review review);
    void deleteById(Long id);
}
