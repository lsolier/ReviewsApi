package com.lsolier.udacity.ReviewsApi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
  private String description;

  @Column(name = "created_at")
  private Timestamp createdTime;

  @OneToMany(mappedBy="review", fetch = FetchType.LAZY)
  @JsonIgnore
  private Set<Comment> comments;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id",  nullable=false)
  @JsonIgnore
  private Product product;

}
