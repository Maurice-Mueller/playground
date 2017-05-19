package moepad.playground.derby.derby;

import moepad.playground.derby.common.*;

import java.util.List;

public final class DerbyHandler {

  private final DerbyConnection connection;

  public DerbyHandler(String dbName) {
    connection = new DerbyConnection(dbName);
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
}