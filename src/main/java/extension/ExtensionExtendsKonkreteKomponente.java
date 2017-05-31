package extension;

public final class ExtensionExtendsKonkreteKomponente extends ExtensionKonkreteKomponente {

  @Override
  public void operation() {
    func1();
    super.operation();
  }

  void func1() {
    System.out.println("ExtensionExtendsKonkreteKomponente: Func1!");
  }
}
