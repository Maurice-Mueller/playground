package moepad.playground.derby.common;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

final public class PreparedStatementParameters {

  private Map<Integer, Object> parameterList = new HashMap<>();

  public void append(Object value) {
    parameterList.put(getNextInteger(), value);
  }

  private Integer getNextInteger() {
    OptionalInt maxIntInMap = parameterList.entrySet().stream().mapToInt(Map.Entry::getKey).max();
    if (maxIntInMap.isPresent())
      return maxIntInMap.getAsInt() + 1;
    return 1;
  }

  public void executePreparedStatement(MyPreparedStatement statement) {
    parameterList.forEach((parameterNumber, value) -> {
        statement.setObject(parameterNumber, value);
    });
    statement.execute();
  }
}
