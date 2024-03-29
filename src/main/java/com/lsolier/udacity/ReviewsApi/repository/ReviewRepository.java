package com.lsolier.udacity.ReviewsApi.repository;

import com.lsolier.udacity.ReviewsApi.model.Product;
import com.lsolier.udacity.ReviewsApi.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

  @Query("SELECT r FROM Review r WHERE r.description LIKE '%LED%'")
  Collection<Review> findAllReviewWhereProductNameContainsLed();

  List<Review> findAllByProduct(Product product);

}
