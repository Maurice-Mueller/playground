package reflectionBasics;

import java.io.Serializable;

@Deprecated
public class ClassWithDeclaredClasses<A, B, C> implements Serializable {

  public final class InnerClass {}
  public final static class StaticInnerClass {}
  public enum InnerEnum {}
  final class PackagePrivateClass{}
  private final class PrivateClass{}



  public String test = "test";


}
