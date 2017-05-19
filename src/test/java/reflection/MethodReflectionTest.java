package reflection;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public final class MethodReflectionTest {

  @Test
  public void testGetMyPrivateString() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    ClassForReflection clazz = new ClassForReflection();
    Method method = ClassForReflection.class.getDeclaredMethod("getMyPrivateString");
    method.setAccessible(true);
    String methodReturn = (String) method.invoke(clazz);
    assertEquals("my private string", methodReturn);
  }
}
