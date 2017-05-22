package mock;

public final class ClassForMockExample {

  private final UsedInterface usedInterface;
  private final int number;

  public ClassForMockExample(int number){
    this.usedInterface = HelperClass.magicMethod();
    this.number = number;
  }

  public int method() {
    return number / usedInterface.getField();
  }

}
