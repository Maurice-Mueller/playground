package moepad.playground.derby.exceptions;

import java.sql.SQLException;

public final class MySQLException extends RuntimeException {

  private final SQLException exception;

  public MySQLException(SQLException e) {
    super(e);
    this.exception = e;
  }

  public boolean isTableAlreadyExistsException() {
    return exception.getSQLState().equalsIgnoreCase("X0Y32");
  }
}
