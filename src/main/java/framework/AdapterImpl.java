package framework;

import interfaces.ClientInterface;

public final class AdapterImpl implements ClientInterface {

  private Adaptee adaptee;

  public AdapterImpl(Adaptee adaptee) {
    this.adaptee = adaptee;
  }

  @Override
  public String operation() {
    int value = adaptee.magicMethod();
    return String.valueOf(value);
  }
}
