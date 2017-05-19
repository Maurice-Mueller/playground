package moepad.playground.derby.derby;

import moepad.playground.derby.common.*;

import java.util.List;

public final class DerbyHandler {

  private final DerbyConnection connection;

  public DerbyHandler(String dbName, boolean destroyDBOnShutdown) {
    connection = new DerbyConnection(dbName);
    if(destroyDBOnShutdown)
      addShutdownHook(dbName);
  }

  public void execute(String sqlStatement) {
    MyStatement statement = connection.createStatement();
    statement.execute(sqlStatement);
    statement.close();
  }

  public void executePreparedStatement(String sqlStatement, List<PreparedStatementParameters> parametersList) {
    MyPreparedStatement statement = connection.createPreparedStatement(sqlStatement);
    parametersList.forEach(parameters -> parameters.executePreparedStatement(statement));
  }

  public MyResultSet query(String query) {
    MyStatement statement = connection.createStatement();
    MyResultSet resultSet = MyResultSetFactory.fromResultSet(statement.executeQuery(query));
    statement.close();
    return resultSet;
  }

  private void addShutdownHook(String dbName) {
    Runtime.getRuntime().addShutdownHook(new DerbyShutdownThread(dbName));
  }
}