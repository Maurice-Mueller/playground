package entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public final class NoEmptyConstructorWihtAnnotationTest {

  @Test
  void test_serialization() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    NoEmptyConstructorWithAnnotation noEmptyConstructorWithAnnotation = new NoEmptyConstructorWithAnnotation("hello123");
    System.out.println(mapper.writeValueAsString(noEmptyConstructorWithAnnotation));
  }

  @Test
  void test_deserialization() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    String asString = "{\"privateString\":\"hello123\"}";
    mapper.readValue(asString, NoEmptyConstructorWithAnnotation.class);
  }
}
