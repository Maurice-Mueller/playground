package usingclasses;

import customannotations.CurrentDate;
import customannotations.SimpleStringAnnotation;
import customannotations.WithArrayAttribute;

import java.time.LocalDate;

public final class WithAnnotations {

  @CurrentDate
  private LocalDate date;

  @SimpleStringAnnotation(value = "helloWorld")
  private String simpleString;

  @WithArrayAttribute(values = {"This", "is", "a", "test"})
  private String stringOfList;

}
