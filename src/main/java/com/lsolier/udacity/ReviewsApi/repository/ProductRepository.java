package com.lsolier.udacity.ReviewsApi.repository;

import com.lsolier.udacity.ReviewsApi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
