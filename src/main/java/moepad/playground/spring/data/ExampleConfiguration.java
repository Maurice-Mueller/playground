package moepad.playground.spring.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class ExampleConfiguration {

  @Bean
  DataSource dataSource() {
     return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.DERBY).build();
  }
}
