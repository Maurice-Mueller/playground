package client;

import interfaces.ClientInterface;

public final class Client {

  public static void main(String[] args) {
    ClientInterface adapter = new AdapterFactory().createAdapter();
    System.out.println(adapter.operation());
  }
}
