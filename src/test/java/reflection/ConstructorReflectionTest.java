package reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorReflectionTest {

  @Test
  public void class_test() throws IllegalAccessException, InstantiationException, NoSuchMethodException {
    ClassForReflection classForReflection = ClassForReflection.class.newInstance();
  }

  @Test
  public void constructor_test_void() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Constructor<ClassForReflection> constructor = ClassForReflection.class.getConstructor();
    constructor.newInstance();
  }

  @Test
  public void constructor_test_int() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Constructor<ClassForReflection> constructor = ClassForReflection.class.getConstructor(int.class);
    constructor.newInstance(100);
  }
}
