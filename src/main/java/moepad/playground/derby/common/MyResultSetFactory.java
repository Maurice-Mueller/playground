package moepad.playground.derby.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class MyResultSetFactory {

  public static MyResultSet fromResultSet(ResultSet resultSet) {
    MyResultSet esentriResultSet = new MyResultSet();
      while (hasNext(resultSet)) {
        List<Object> results = IntStream.range(1, getColumnCount(resultSet) + 1)
            .mapToObj(MyResultSetFactory.getObject(resultSet)).collect(Collectors.toList());
        esentriResultSet.append(results);
      }
    return esentriResultSet;
  }

  private static boolean hasNext(ResultSet resultSet) {
    try {
      return resultSet.next();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static int getColumnCount(ResultSet resultSet) {
    try {
      return resultSet.getMetaData().getColumnCount();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static IntFunction<Object> getObject(ResultSet resultSet) {
    return (index) -> {
      try {
        return resultSet.getObject(index);
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    };
  }
}
