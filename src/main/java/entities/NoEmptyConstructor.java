package entities;

public final class NoEmptyConstructor {
  private String fail;

  NoEmptyConstructor(String fail) {
    this.fail = fail;
  }

  public String getFail() {
    return fail;
  }

  public void setFail(String fail) {
    this.fail = fail;
  }
}
