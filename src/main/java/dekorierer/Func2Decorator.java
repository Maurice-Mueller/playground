package dekorierer;

public final class Func2Decorator extends AbstractDecorator {

  Func2Decorator(Komponente komponente) {
    super(komponente);
  }

  @Override
  public void operation() {
    komponente.operation();
    func2();
  }

  private void func2() {
    System.out.println("Func2Decorator: Func2!");
  }
}
