package com.lsolier.udacity.ReviewsApi.controller;

import com.lsolier.udacity.ReviewsApi.model.Product;
import com.lsolier.udacity.ReviewsApi.model.Review;
import com.lsolier.udacity.ReviewsApi.repository.ProductRepository;
import com.lsolier.udacity.ReviewsApi.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

    private ReviewRepository reviewRepository;

    private ProductRepository productRepository;

    @Autowired
    public ReviewsController(ProductRepository productRepository,
                             ReviewRepository reviewRepository) {
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
    }

    /**
     * Creates a review for a product.
     * <p>
     * 1. Add argument for review entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of product.
     * 3. If product not found, return NOT_FOUND.
     * 4. If found, save review.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public ResponseEntity<Review> createReviewForProduct(@PathVariable("productId") Integer productId,
                                                         @RequestBody Review review) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        Product product = optionalProduct.orElseThrow(() -> new HttpServerErrorException(HttpStatus.NOT_FOUND));
        review.setProduct(product);
        reviewRepository.save(review);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    /**
     * Lists reviews by product.
     *
     * @param productId The id of the product.
     * @return The list of reviews.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<List<Review>> listReviewsForProduct(@PathVariable("productId") Integer productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        Product product = optionalProduct.orElseThrow(() -> new HttpServerErrorException(HttpStatus.NOT_FOUND));
        List<Review> reviewList = reviewRepository.findAllByProduct(product);
        return new ResponseEntity<>(reviewList, HttpStatus.OK);
    }
}