package entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de_serializer.LocalDateDeserializer;
import de_serializer.LocalDateSerializer;

import java.time.LocalDate;

public final class UserWithCustomBirthday {

  @JsonProperty
  private String name;

  @JsonProperty
  @JsonSerialize(using = LocalDateSerializer.class)
  @JsonDeserialize(using = LocalDateDeserializer.class)
  private LocalDate birthday;

  public UserWithCustomBirthday() {
  }

  public UserWithCustomBirthday(String name, LocalDate birthday) {
    this.name = name;
    this.birthday = birthday;
  }
}
