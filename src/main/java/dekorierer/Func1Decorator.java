package dekorierer;

public final class Func1Decorator extends AbstractDecorator {

  Func1Decorator(Komponente komponente) {
    super(komponente);
  }

  @Override
  public void operation() {
    func1();
    komponente.operation();
  }

  private void func1() {
    System.out.println("Func1Decorator: Func1!");
  }
}
