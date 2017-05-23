package entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class NoGetterAndSetterWithAnnotationTest {

  @Test
  void test_serialization() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    System.out.println(mapper.writeValueAsString(new NoGetterAndSetterWithAnnotation()));
  }

  @Test
  void test_deserialization() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    String asString = "{\"privateString\":\"test1234\"}";
    NoGetterAndSetterWithAnnotation entity = mapper.readValue(asString, NoGetterAndSetterWithAnnotation.class);
    entity.printValue();
  }
}
