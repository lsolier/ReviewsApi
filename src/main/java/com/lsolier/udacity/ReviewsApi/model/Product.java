package com.lsolier.udacity.ReviewsApi.model;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

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

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "review_id", referencedColumnName = "id")
  private Review review;

}
