package annotations.customannotations;

public @interface WithDefaultValues {
  boolean testBoolean() default true;
  String name() default "Max Muster";
}
