package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class NoGetterAndSetterWithAnnotation {

  @JsonProperty
  private String privateString = "private";

  void printValue() {
    System.out.println(privateString);
  }
}
