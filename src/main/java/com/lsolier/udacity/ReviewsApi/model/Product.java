package com.lsolier.udacity.ReviewsApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "product_name")
  private String productName;

  @Column(name = "created_at")
  private Timestamp createdTime;

  @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
  @JsonIgnore
  private Set<Review> review;

}
