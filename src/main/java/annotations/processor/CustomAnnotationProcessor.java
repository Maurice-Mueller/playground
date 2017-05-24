package annotations.processor;

import annotations.customannotations.CurrentDate;

import java.lang.reflect.Field;
import java.util.Arrays;

public class CustomAnnotationProcessor {
  static {
    Class<?> clazz = loadClass("annotations.usingclasses.WithAnnotations");
    Arrays.stream(clazz.getDeclaredFields()).forEach(field -> {
      boolean wasAccessibleBefore = makeFieldAccesible(field);
      CurrentDate currentDate = field.getAnnotation(CurrentDate.class);
      if (currentDate != null)
        System.out.println("Found");
      field.setAccessible(wasAccessibleBefore);
    });
  }

  private static boolean makeFieldAccesible(Field field) {
    boolean isAccessible = field.isAccessible();
    if(!isAccessible)
      field.setAccessible(true);
    return isAccessible;
  }

  private static <T> Class<T> loadClass(String className) {
    ClassLoader classLoader = CustomAnnotationProcessor.class.getClassLoader();
    try {
     return (Class<T>) classLoader.loadClass(className);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
