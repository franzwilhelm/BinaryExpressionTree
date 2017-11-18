import java.util.LinkedList;

class MathTree {
  static Node root;

  MathTree(String expr) {
    root = buildTree(listify(expr.replaceAll(" ", "")));
  }

  private LinkedList<Node> listify(String expr) {
    LinkedList<Node> list = new LinkedList<>();
    Node n = null;
    for (int i = 0; i < expr.length(); i += n.value.length()) {
      String currExp = expr.substring(i);
      n = Operator.parse(currExp);
      if (n == null) {
        n = Digit.parse(currExp);
      }
      list.add(n);
    }
    return list;
  }

  private Node getfirstOperator(LinkedList<Node> nodes) {
    Node first = null;
    int pri = 0;
    for (Node n : nodes) {
      if (Operator.isOperator(n)) {
        if (n.isOneOf(Operator.SUB, Operator.ADD)) {
          first = n;
          break;
        } else if (pri < 3 && n.isOneOf(Operator.DIVIDE, Operator.MULTIPLY)) {
          first = n;
          pri = 3;
        } else if (pri < 2 && n.isOneOf(Operator.POW)) {
          first = n;
          pri = 3;
        } else if (pri < 1 && n.isOneOf(Operator.COS, Operator.SIN, Operator.TAN)) {
          first = n;
          pri = 1;
        }
      }
    }
    return first;
  }

  private Node buildTree(LinkedList<Node> nodes) {
    if (nodes.size() == 1) return nodes.getFirst();
    if (nodes.isEmpty()) return null;

    Node operator = getfirstOperator(nodes);
    LinkedList<Node> left = new LinkedList<Node>();
    LinkedList<Node> right = new LinkedList<Node>();

    boolean found = false;
    for (Node n : nodes) {
      if (n == operator) {
        found = true;
      } else {
        if (!found) left.add(n);
        else right.add(n);
      }
    }

    operator.left = buildTree(left);
    operator.right = buildTree(right);
    return operator;
  }

  @Override
  public String toString() {
    if (root != null) return root.toString();
    else return "Empty tree";
  }

  static double calculate() {
    return root.calculate();
  }
}
