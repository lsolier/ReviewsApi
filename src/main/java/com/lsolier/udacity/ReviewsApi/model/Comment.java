package com.lsolier.udacity.ReviewsApi.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "description")
  private String description;

  @Column(name = "created_at")
  private Timestamp createdTime;

  @ManyToOne
  @JoinColumn(name="review_id", nullable=false)
  private Review review;

}
