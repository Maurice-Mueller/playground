package moepad.playground.derby.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class MyResultSet {

  private final List<List<Object>> resultList = new ArrayList<>();

  MyResultSet() {
  }

  void append(List<Object> values) {
    resultList.add(values);
  }

  public Stream<List<Object>> stream() {
    return resultList.stream();
  }
}