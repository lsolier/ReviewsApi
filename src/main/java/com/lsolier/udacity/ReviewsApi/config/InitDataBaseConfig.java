package com.lsolier.udacity.ReviewsApi.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDataBaseConfig {

  @Bean
  public CommandLineRunner initDataBase(DataSourceConfig dataSourceConfig) {
    return Args -> {
      Flyway flyway = Flyway.configure().dataSource(dataSourceConfig.getDataSource()).load();
      flyway.repair();
      flyway.migrate();
      System.out.println("Flyway was successful");
    };
  }
}
