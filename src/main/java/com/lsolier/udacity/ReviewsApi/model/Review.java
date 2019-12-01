package com.lsolier.udacity.ReviewsApi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "description")
  private String productName;

  @Column(name = "created_at")
  private Timestamp createdTime;

  @OneToMany(mappedBy="review")
  private Set<Comment> comments;

  @OneToOne(mappedBy = "review")
  private Product product;

}
