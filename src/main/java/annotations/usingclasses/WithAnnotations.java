package annotations.usingclasses;

import annotations.customannotations.CurrentDate;
import annotations.customannotations.SimpleStringAnnotation;
import annotations.customannotations.WithArrayAttribute;

import java.time.LocalDate;

public final class WithAnnotations {

  @CurrentDate
  private LocalDate date;

  @SimpleStringAnnotation(value = "helloWorld")
  private String simpleString;

  @WithArrayAttribute(values = {"This", "is", "a", "test"})
  private String stringOfList;

}
