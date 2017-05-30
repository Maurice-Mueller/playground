package aspects;

import classes.Account;

public aspect AccountAspect {

  pointcut callWithdraw(Account account, int amount) :
    call(void Account.withdraw(int)) && target(account) && args(amount);

  before(Account account, int amount): callWithdraw(account, amount) {
    System.out.println("Account " + account.toString() + " lost money: " + amount);
    throw new NullPointerException();
  }
}