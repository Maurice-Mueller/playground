package entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class NoGetterAndSetterTest {

  @Test
  void test_serialization() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    assertThrows(JsonMappingException.class, () -> mapper.writeValueAsString(new NoGetterAndSetter()));
  }

  @Test
  void test_deserialization() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    String asString = "{\"privateString\":\"test\"}";
    assertThrows(UnrecognizedPropertyException.class, () -> mapper.readValue(asString, NoGetterAndSetter.class));
  }
}
