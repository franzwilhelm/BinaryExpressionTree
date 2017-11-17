class MathTree {
  private static final String
  EXP = "^",
  DIVIDE = "/",
  MULTIPLY = "*",
  SUB = "-",
  ADD = "+",
  COS = "cos",
  SIN = "sin",
  TAN = "tan";
  static final String[] operators = {EXP, DIVIDE, MULTIPLY, SUB, ADD, COS, SIN, TAN};
  static Node root;

  MathTree(String expr) throws Exception {
    for (int i = 0; i < expr.length(); i++) {
      Node n = operator(expr.substring(i));
      if (n == null) {
        String digit = expr.substring(i, i + 1);
        try {
          int parsed = Integer.parseInt(digit);
          n = new Digit(parsed);
        } catch (Exception e) {
          System.out.printf("Operand not supported yet: '%s'", digit);
          System.exit(1);
        }
        this.insert(n);
      } else {
        i += ((String) n.value).length() - 1;
        n.insert(root);
        root = n;
      }
    }
  }

  static int calculate() {
    return root.calculate();
  }

  private static void insert(Node n) throws Exception{
    if (root != null) root.insert(n);
    else root = n;
  }

  private static Operator operator(String s) {
    Operator o = null;
    L: for (String operator : operators) {
      for (int i = 0; i < operator.length() && i < s.length(); i++ ) {
        String val = s.substring(0, i + 1);
        if (val.equals(operator)) {
          o = new Operator(val);
          break L;
        }
      }

    }
    return o;
  }

}
