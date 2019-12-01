package com.lsolier.udacity.ReviewsApi.repository;

import com.lsolier.udacity.ReviewsApi.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
