package moepad.playground.spring.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

//For more examples see https://docs.spring.io/spring-boot/docs/current/reference/html/howto-data-access.html#howto-configure-a-datasource
@Configuration
public class ExampleConfiguration {

  @Bean
  DataSource dataSource() {
     return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.DERBY).build();
  }
}
