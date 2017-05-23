package entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class PrimitiveDataTypesTest {

  @Test
  void test_serialization() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    System.out.println(mapper.writeValueAsString(new PrimitiveDataTypes()));
  }

  @Test
  void test_deserialization() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    String asString = "{\"integer\":0,\"booleanValue\":false,\"character\":\"\\u0000\",\"byteValue\":0,\"doubleValue\":0.0,\"floatValue\":0.0,\"longValue\":0,\"shortValue\":0}";
    PrimitiveDataTypes primitiveDataTypes = mapper.readValue(asString, PrimitiveDataTypes.class);
    assertEquals(0, primitiveDataTypes.getInteger());
    assertEquals(false, primitiveDataTypes.isBooleanValue());
    assertEquals('\u0000', primitiveDataTypes.getCharacter());
    assertEquals(Byte.decode("0").byteValue(), primitiveDataTypes.getByteValue());
    assertEquals(0.0, primitiveDataTypes.getDoubleValue());
    assertEquals(0.0, primitiveDataTypes.getFloatValue());
    assertEquals(0, primitiveDataTypes.getShortValue());
    assertEquals(0, primitiveDataTypes.getLongValue());
  }
}
