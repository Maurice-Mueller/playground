package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class NoEmptyConstructorWithAnnotation {

  @JsonProperty
  private String privateString = "private";

  NoEmptyConstructorWithAnnotation(String privateString) {
    this.privateString = privateString;
  }
}
