package entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UserStandardTest {

  @Test
  void test_serialization() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    UserStandard userStandard = new UserStandard("Max Muster", LocalDate.of(2000, 1, 1));
    String asString = mapper.writeValueAsString(userStandard);
    System.out.println(asString);
  }

  @Test
  void test_deserialization() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    String asString = "{\"name\":\"Max Muster\",\"birthday\":{\"year\":2000,\"month\":\"JANUARY\",\"era\":\"CE\",\"dayOfYear\":1,\"dayOfWeek\":\"SATURDAY\",\"leapYear\":true,\"dayOfMonth\":1,\"monthValue\":1,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}}}";
    assertThrows(JsonMappingException.class, () -> mapper.readValue(asString, UserStandard.class));
  }


}
