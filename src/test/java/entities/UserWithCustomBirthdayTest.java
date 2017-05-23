package entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

public final class UserWithCustomBirthdayTest {

  @Test
  void test_serialization() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    UserWithCustomBirthday user = new UserWithCustomBirthday("Max Muster", LocalDate.of(2000, 1, 1));
    String userAsString = mapper.writeValueAsString(user);
    System.out.println(userAsString);
  }

  @Test
  void test_derialization() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    String userAsString = "{\"name\":\"Max Muster\",\"birthday\": \"2000|01|01\"}";
    UserWithCustomBirthday user =  mapper.readValue(userAsString, UserWithCustomBirthday.class);
  }
}
