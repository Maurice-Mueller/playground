package moepad.playground.derby.derby;

import moepad.playground.derby.common.MyPreparedStatement;
import moepad.playground.derby.common.MyStatement;
import moepad.playground.derby.exceptions.MySQLException;

import java.sql.*;
import java.util.Properties;

final class DerbyConnection {

  private final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
  private final Connection connection;

  DerbyConnection(String dbName) {
    connection = initializeDatabase(dbName);
    addShutdownHook(dbName);
  }

  private Connection initializeDatabase(String dbName) {
    try {
      String dataBaseUrl = "jdbc:derby:" + dbName;
      Class.forName(driver).newInstance();
      return DriverManager.getConnection(dataBaseUrl + ";create=true", new Properties());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void addShutdownHook(String dbName) {
    Runtime.getRuntime().addShutdownHook(new DerbyShutdownThread(dbName));
  }

  MyStatement createStatement() {
    try {
      return new MyStatement(connection.createStatement());
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  MyPreparedStatement createPreparedStatement(String statement) {
    try {
      return new MyPreparedStatement(connection.prepareStatement(statement));
    } catch (SQLException e) {
      throw new MySQLException(e);
    }
  }
}
