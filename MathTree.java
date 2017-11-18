class MathTree {
  static Node root;

  MathTree(String expr) {
    System.out.println("expr is " + expr);
    for (int i = 0; i < expr.length(); i++) {
      String currExp = expr.substring(i);
      Node n = Operator.parse(currExp);
      if (n == null) {
        n = Digit.parse(currExp);
        this.insert(n);
      } else {
        n.insert(root);
        root = n;
      }
      i += n.value.length() - 1;
    }
  }

  @Override
  public String toString() {
    if (this.root != null){
      return String.format(" %-8s%s\n\n", this.root, this.root.toString(0));
    }
    return "";
  }

  static double calculate() {
    return root.calculate();
  }

  private static void insert(Node n) {
    if (root != null) root.insert(n);
    else root = n;
  }

}
