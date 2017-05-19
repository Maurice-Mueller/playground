package moepad.playground.derby.exceptions;

import java.sql.SQLException;

public final class MySQLException extends RuntimeException {

  public MySQLException(SQLException e) {
    super(e);
  }
}
