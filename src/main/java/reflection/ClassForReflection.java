package reflection;

public final class ClassForReflection {

  private String myPrivateString = "my private string";
  private String nonFinalString = "my non final string";
  private final String finalString = "my final string";
  private final String stringForGetting = "string get";

  public ClassForReflection() {}

  public ClassForReflection(int i) {}

  private String getMyPrivateString() {
    return myPrivateString;
  }

  public String getStringForGetting() {
    return stringForGetting;
  }
}
