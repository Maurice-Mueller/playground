package reflectionBasics;

import org.junit.Test;

import java.util.Arrays;

public class GetClassesTest {

  @Test
  public void test_getSuperClass() {

  }

  @Test
  public void test_getClasses() {
    Arrays.asList(ClassWithDeclaredClasses.class.getTypeParameters()).forEach(System.out::println);
  }

  @Test
  public void test_getDeclaredClasses() {
    Arrays.asList(ClassWithDeclaredClasses.class.getDeclaredClasses()).forEach(System.out::println);
  }

  @Test
  public void test_getDeclaringClass() {

  }

  @Test
  public void test_getEnclosingClass() {

  }
}
