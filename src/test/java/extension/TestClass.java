package extension;

import org.junit.jupiter.api.Test;

public final class TestClass {

  @Test
  void test_extensionKonkreteKomponente() {
    ExtensionKomponente extensionKomponente = new ExtensionKonkreteKomponente();
    extensionKomponente.operation();
  }

  @Test
  void test_extensionExtendsKonkreteKomponente() {
    ExtensionKomponente extensionKomponente = new ExtensionExtendsKonkreteKomponente();
    extensionKomponente.operation();
  }

  @Test
  void test_extensionExtendsKonkreteKomponente2() {
    ExtensionKomponente extensionKomponente = new ExtensionExtendsKonkreteKomponente2();
    extensionKomponente.operation();
  }
}
