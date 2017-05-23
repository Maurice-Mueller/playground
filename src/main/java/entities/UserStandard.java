package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public final class UserStandard {

  @JsonProperty
  private String name;

  @JsonProperty
  private LocalDate birthday;

  public UserStandard() {}

  public UserStandard(String name, LocalDate birthday) {
    this.name = name;
    this.birthday = birthday;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getBirthday() {
    return birthday;
  }

  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }
}
