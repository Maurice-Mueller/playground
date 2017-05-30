package aspects;

import classes.Account;
import org.junit.jupiter.api.Test;

public final class SimpleTest {

  @Test
  void test() {
    Account account = new Account();
    account.withdraw(100);
  }

}
