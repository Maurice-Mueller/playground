package dekorierer;

public abstract class AbstractDecorator implements Komponente {

  protected final Komponente komponente;

  AbstractDecorator(Komponente komponente) {
    this.komponente = komponente;
  }

}
