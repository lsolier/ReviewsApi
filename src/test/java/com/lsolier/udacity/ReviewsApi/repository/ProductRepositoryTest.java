package com.lsolier.udacity.ReviewsApi.repository;

import com.lsolier.udacity.ReviewsApi.model.Product;
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

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

  @Autowired
  private DataSource dataSource;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private EntityManager entityManager;

  @Autowired
  private TestEntityManager testEntityManager;

  @Autowired
  private ProductRepository productRepository;

  @Test
  public void injectedComponentsAreNotNull(){
    AssertionsForClassTypes.assertThat(dataSource).isNotNull();
    AssertionsForClassTypes.assertThat(jdbcTemplate).isNotNull();
    AssertionsForClassTypes.assertThat(entityManager).isNotNull();
    AssertionsForClassTypes.assertThat(testEntityManager).isNotNull();
    AssertionsForClassTypes.assertThat(productRepository).isNotNull();
  }

  @Test
  public void testMethods(){

    Product product = new Product();
    product.setProductName("Nissan Test NUEVA");
    product.setCreatedTime(Timestamp.valueOf(LocalDateTime.now()));

    productRepository.save(product);

    Product actual = productRepository.findByProductName("Nissan Test NUEVA");
    AssertionsForClassTypes.assertThat(actual).isNotNull();
    Assert.assertEquals(product.getId(), actual.getId());

    Collection<Product> productCollection = productRepository.findAllProductWhereProductNameContainsNueva();
    AssertionsForClassTypes.assertThat(productCollection).isNotNull();
  }

}