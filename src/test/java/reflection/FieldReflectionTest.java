package reflection;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public final class FieldReflectionTest {

  @Test
  public void testGettingPrivateField() throws NoSuchFieldException, IllegalAccessException {
    ClassForReflection clazz = new ClassForReflection();
    Field privateField = ClassForReflection.class.getDeclaredField("myPrivateString");
    privateField.setAccessible(true);
    String valueOfPrivateField = (String) privateField.get(clazz);
    assertEquals("my private string", valueOfPrivateField);
  }

  @Test
  public void testSettingPrivateField() throws NoSuchFieldException, IllegalAccessException {
    ClassForReflection clazz = new ClassForReflection();
    Field privateField = ClassForReflection.class.getDeclaredField("nonFinalString");
    privateField.setAccessible(true);
    privateField.set(clazz, "new value 1234");
    String valueOfPrivateField = (String) privateField.get(clazz);
    assertEquals("new value 1234", valueOfPrivateField);
  }

  @Test
  public void testSettingPrivateField_final() throws NoSuchFieldException, IllegalAccessException {
    ClassForReflection clazz = new ClassForReflection();
    Field privateField = ClassForReflection.class.getDeclaredField("finalString");
    privateField.setAccessible(true);
    privateField.set(clazz, "new value 1234");
    String valueOfPrivateField = (String) privateField.get(clazz);
    assertEquals("new value 1234", valueOfPrivateField);
  }
}
