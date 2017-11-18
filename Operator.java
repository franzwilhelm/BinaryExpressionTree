class Operator extends Node {
  static final String
  POW      = "^",
  DIVIDE   = "/",
  MULTIPLY = "*",
  SUB      = "-",
  ADD      = "+",
  COS      = "cos",
  SIN      = "sin",
  TAN      = "tan";

  private static final String[] operators = { POW, DIVIDE, MULTIPLY, SUB, ADD, COS, SIN, TAN };

  private Operator(String value) {
    super(value);
  }

  public double calculate() {
    Double r = null;
    Double l = null;
    if (this.right != null) r = this.right.calculate();
    if (this.left != null) l = this.left.calculate();

    if (r != null && l != null) return this.operate(l, r);
    else if (r != null) return this.operate(r);
    else {
      System.out.printf("Missing operands for operator %s", this.value);
      System.exit(1);
    }
    return -1;
  }

  private double operate(double l, double r) {
    switch (this.value) {
      case DIVIDE:   return l / r;
      case MULTIPLY: return l * r;
      case SUB:      return l - r;
      case ADD:      return l + r;
      case POW:      return Math.pow(l, r);
    }
    System.out.printf("Cannot operate with operator '%s'", this.value);
    System.exit(1);
    return -1;
  }

  private double operate(double l) {
    switch (this.value) {
      case COS: return Math.cos(l);
      case SIN: return Math.sin(l);
      case TAN: return Math.tan(l);
    }
    System.out.printf("Cannot operate with operator '%s'", this.value);
    System.exit(1);
    return -1;
  }

  static Node parse(String s) {
    for (int i = 0; i < s.length(); i++) {
      String val = s.substring(0, i + 1);
      if (isOperator(val)) return new Operator(val);
    }
    return null;
  }

  static boolean isOperator(String s) {
    for (String operator : operators) {
      if (s.equals(operator)) {
        return true;
      }
    }
    return false;
  }

  static boolean isOperator(Node n) {
    return n instanceof Operator;
  }
}
