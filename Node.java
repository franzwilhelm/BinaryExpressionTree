abstract class Node implements Comparable<Node> {
  protected Node left;
  protected Node right;
  protected String value;
  private String horizontal = "----" ;
  private String vertical = "|";

  protected Node(String value) {
    this.value = value;
  }

  abstract void insert(Node n);
  abstract double calculate();

  String toString(int ind) {
    String indent = " ";
    for (int i = 0; i < ind; i++) {
      indent += "|     ";
    }
    return String.format("%s%s",
      (this.right != null)
        ? String.format(horizontal + "%-8s%s", this.right.value, this.right.toString(ind + 1))
        : "",
      (this.left != null)
        ? String.format("\n%s %s\n%s", indent, vertical, indent) +
        String.format("%-8s%s", this.left.value, this.left.toString(ind))
        : "");
  }

  @Override
  public String toString() {
    return this.value;
  }

  @Override
  public abstract int compareTo(Node other);

}
