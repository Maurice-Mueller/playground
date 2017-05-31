package dekorierer;

import org.junit.jupiter.api.Test;

public final class TestClass {

  @Test
  void test_konkreteKomponente() {
    Komponente komponente = new KonkreteKomponente();
    komponente.operation();
  }

  @Test
  void test_func1Decorator() {
    Komponente komponente = new Func1Decorator(new KonkreteKomponente());
    komponente.operation();
  }

  @Test
  void test_func2Decorator() {
    Komponente komponente = new Func2Decorator(new KonkreteKomponente());
    komponente.operation();
  }

  @Test
  void test_func2Decorator_komp2() {
    Komponente komponente = new Func2Decorator(new KonkreteKomponente2());
    komponente.operation();
  }

  @Test
  void test_dec22() {
    Komponente komponente = new KonkreteKomponente();
    Komponente dec1 = new Func2Decorator(komponente);
    Komponente dec2 = new Func1Decorator(dec1);
    dec2.operation();
  }
}
