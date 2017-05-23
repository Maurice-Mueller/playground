package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import annotations.processor.CustomAnnotationProcessor;

public final class TestTest {

  @BeforeAll
  static void beforeAll() {
    new CustomAnnotationProcessor();
  }

  @Test
  void test(){
    System.out.println("Hello");
  }


}
