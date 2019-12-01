package com.lsolier.udacity.ReviewsApi.repository;

import com.lsolier.udacity.ReviewsApi.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
