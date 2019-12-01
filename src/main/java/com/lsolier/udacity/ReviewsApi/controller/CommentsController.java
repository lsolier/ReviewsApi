package com.lsolier.udacity.ReviewsApi.controller;

import com.lsolier.udacity.ReviewsApi.model.Comment;
import com.lsolier.udacity.ReviewsApi.model.Review;
import com.lsolier.udacity.ReviewsApi.repository.CommentRepository;
import com.lsolier.udacity.ReviewsApi.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    private CommentRepository commentRepository;

    private ReviewRepository reviewRepository;

    @Autowired
    public CommentsController(CommentRepository commentRepository,
                              ReviewRepository reviewRepository) {
        this.commentRepository = commentRepository;
        this.reviewRepository = reviewRepository;
    }

    /**
     * Creates a comment for a review.
     *
     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public ResponseEntity<Comment> createCommentForReview(@PathVariable("reviewId") Integer reviewId,
                                                          @RequestBody Comment comment) {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
        Review review = reviewOptional.orElseThrow(
            () -> new HttpServerErrorException(HttpStatus.NOT_FOUND));
        comment.setReview(review);
        commentRepository.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    /**
     * List comments for a review.
     *
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public List<Comment> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
        Review review = reviewOptional.orElseThrow(
            () -> new HttpServerErrorException(HttpStatus.NOT_FOUND));

        List<Comment> commentList;
        commentList = commentRepository.findAllByReview(review);
        return commentList;
    }
}