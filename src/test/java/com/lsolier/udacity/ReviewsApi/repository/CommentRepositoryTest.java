package com.lsolier.udacity.ReviewsApi.repository;

import com.lsolier.udacity.ReviewsApi.model.Comment;
import com.lsolier.udacity.ReviewsApi.model.Product;
import com.lsolier.udacity.ReviewsApi.model.Review;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

  @Autowired
  private DataSource dataSource;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private EntityManager entityManager;

  @Autowired
  private TestEntityManager testEntityManager;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private ReviewRepository reviewRepository;

  @Autowired
  private ProductRepository productRepository;

  @Test
  public void injectedComponentsAreNotNull(){
    AssertionsForClassTypes.assertThat(dataSource).isNotNull();
    AssertionsForClassTypes.assertThat(jdbcTemplate).isNotNull();
    AssertionsForClassTypes.assertThat(entityManager).isNotNull();
    AssertionsForClassTypes.assertThat(testEntityManager).isNotNull();
    AssertionsForClassTypes.assertThat(commentRepository).isNotNull();
    AssertionsForClassTypes.assertThat(reviewRepository).isNotNull();
    AssertionsForClassTypes.assertThat(productRepository).isNotNull();
  }

  @Test
  public void testMethods(){

    Product product = new Product();
    product.setProductName("Nissan Test NUEVA");
    product.setCreatedTime(Timestamp.valueOf(LocalDateTime.now()));
    productRepository.save(product);

    Review review = new Review();
    review.setProduct(product);
    review.setDescription("Review Test mas");
    review.setCreatedTime(Timestamp.valueOf(LocalDateTime.now()));
    reviewRepository.save(review);

    Comment comment = new Comment();
    comment.setReview(review);
    comment.setDescription("Comentario Test mas");
    commentRepository.save(comment);

    List<Comment> actual = commentRepository.findAllByReview(review);
    AssertionsForClassTypes.assertThat(actual).isNotNull();
    Assert.assertEquals(comment.getId(), actual.get(0).getId());

    Collection<Comment> commentCollection = commentRepository.findAllCommentWhereDescriptionContainsMas();
    AssertionsForClassTypes.assertThat(commentCollection).isNotNull();

  }
}
