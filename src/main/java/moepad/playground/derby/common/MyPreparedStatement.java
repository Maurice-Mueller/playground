package moepad.playground.derby.common;

import moepad.playground.derby.exceptions.MySQLException;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class MyPreparedStatement {

  private final PreparedStatement preparedStatement;

  public MyPreparedStatement(PreparedStatement statement) {
    preparedStatement = statement;
  }

  void setObject(int parameterNumber, Object parameter) {
    try {
      preparedStatement.setObject(parameterNumber, parameter);
    } catch (SQLException e) {
      throw new MySQLException(e);
    }
  }

  void execute() {
    try {
      preparedStatement.execute();
    } catch (SQLException e) {
      throw new MySQLException(e);
    }
  }

}
