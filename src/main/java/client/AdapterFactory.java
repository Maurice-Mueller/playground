package client;

import framework.Adaptee;
import framework.AdapterImpl;
import interfaces.ClientInterface;

public final class AdapterFactory {

  ClientInterface createAdapter() {
    return new AdapterImpl(new Adaptee());
  }
}
