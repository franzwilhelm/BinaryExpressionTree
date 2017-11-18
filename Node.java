abstract class Node {
  protected Node left;
  protected Node right;
  protected String value;
  private String horizontal = "----" ;
  private String vertical = "|";

  protected Node(String value) {
    this.value = value;
  }

  abstract double calculate();

  boolean isOneOf(String... operators) {
    for (String operator : operators) {
      if (this.value.equals(operator)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    String ret = "";
    if (this.left != null) ret += this.left.toString();
    ret += this.value;
    if (this.right != null) ret += this.right.toString();
    return ret;
  }

}
