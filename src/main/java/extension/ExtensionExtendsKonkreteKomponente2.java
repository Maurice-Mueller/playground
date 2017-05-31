package extension;

public final class ExtensionExtendsKonkreteKomponente2 extends ExtensionKonkreteKomponente {

  @Override
  public void operation() {
    super.operation();
    func2();
  }

  void func2() {
    System.out.println("ExtensionExtendsKonkreteKomponente2: Func2!");
  }
}
