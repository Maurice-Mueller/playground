package entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserStandardTest {

  @Test
  void test_serialization() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    UserStandard userStandard = new UserStandard("Max Muster", "2000-01-01");
    String asString = mapper.writeValueAsString(userStandard);
    System.out.println(asString);
  }

  @Test
  void test_deserialization() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    String asString = "{\"name\":\"Max Muster\",\"birthday\":\"2000-01-01\"}";
    UserStandard userStandard = mapper.readValue(asString, UserStandard.class);
    assertEquals("Max Muster", userStandard.getName());
    assertEquals("2000-01-01", userStandard.getBirthday());
  }

  //UserStandard userStandard = new UserStandard("Max Muster", LocalDate.of(2000, 01, 01));

}
