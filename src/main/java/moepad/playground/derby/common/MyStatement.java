package moepad.playground.derby.common;

import moepad.playground.derby.exceptions.MySQLException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class MyStatement {

  private final Statement statement;

  public MyStatement(Statement statement) {
    this.statement = statement;
  }

  public void execute(String statementString) {
    try {
      this.statement.execute(statementString);
    } catch (SQLException e) {
      throw new MySQLException(e);
    }
  }

  public void close() {
    try {
      statement.close();
    } catch (SQLException e) {
      throw new MySQLException(e);
    }
  }

  public ResultSet executeQuery(String query) {
    try {
      return statement.executeQuery(query);
    } catch (SQLException e) {
      throw new MySQLException(e);
    }
  }
}
