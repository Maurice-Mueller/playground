package classes;

public final class Account {

  private int balance = 1000;

  public void withdraw(int amount) {
    balance -= amount;
  }

  public void deposit(int amount) {
    balance += amount;
  }
}
