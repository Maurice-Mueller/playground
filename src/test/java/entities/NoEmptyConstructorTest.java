package entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public final class NoEmptyConstructorTest {

  @Test
  void test_serialzation() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    System.out.println(mapper.writeValueAsString(new NoEmptyConstructor("test")));
  }

  @Test
  void test_deserialization() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    String asString = "{\"fail\":\"test\"}";
    assertThrows(JsonMappingException.class, () -> mapper.readValue(asString, NoEmptyConstructor.class));
  }
}
