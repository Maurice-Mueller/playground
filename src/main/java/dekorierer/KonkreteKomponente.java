package dekorierer;

public final class KonkreteKomponente implements Komponente {

  @Override
  public void operation() {
    System.out.println("KonkreteKomponente: Hello!");
  }
}
