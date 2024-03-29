package com.lsolier.udacity.ReviewsApi.repository;

import com.lsolier.udacity.ReviewsApi.model.Comment;
import com.lsolier.udacity.ReviewsApi.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

  @Query("SELECT c FROM Comment c WHERE c.description LIKE '%mas%'")
  Collection<Comment> findAllCommentWhereDescriptionContainsMas();

  List<Comment> findAllByReview(Review review);

}
