package moepad.playground.derby.derby;

import java.sql.DriverManager;
import java.sql.SQLException;

final class DerbyShutdownThread extends Thread {

  private final String shutdownCommand;

  DerbyShutdownThread(String dbName) {
    shutdownCommand = "jdbc:derby:" + dbName + ";shutdown=true";
  }

  @Override
  public void run() {
    try {
      DriverManager.getConnection(shutdownCommand);
    } catch (SQLException exception) {
    }
    System.out.println("Database successfully shut down.");
  }
}
