package com.esentri.spring;

public final class DoubleGreeting {

  private final String name1;
  private final String name2;

  DoubleGreeting(String name1, String name2) {
    this.name1 = name1;
    this.name2 = name2;
  }

  public String getName1() {
    return name1;
  }

  public String getName2() {
    return name2;
  }
}
