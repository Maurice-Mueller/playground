package moepad.playground.derby.tables;

import moepad.playground.derby.derby.DerbyHandler;
import moepad.playground.derby.exceptions.MySQLException;

import java.util.List;
import java.util.stream.Collectors;

public final class TableHandler {

  private final DerbyHandler derbyHandler;
  private final static String createTemplate = "create table %s(%s)";

  public TableHandler(DerbyHandler derbyHandler) {
    this.derbyHandler = derbyHandler;
  }

  public void createTableIfNotExists(String tableName, List<String> columns) {
    String columnsAsString = columns.stream().collect(Collectors.joining(", "));
    try {
      derbyHandler.execute(String.format(createTemplate, tableName, columnsAsString));
    } catch (MySQLException e) {
      if(!e.isTableAlreadyExistsException())
        throw e;
    }
  }

}
