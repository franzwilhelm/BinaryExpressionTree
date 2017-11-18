class Digit extends Node {

  private Digit(String value) {
    super(value);
    if (value.length() == 0) {
      System.out.println("Tried to create empty digit, exiting");
      System.exit(1);
    }
  }

  public double calculate() {
    return Double.parseDouble(this.value);
  }

  static Node parse(String s) {
    String digit = "";
    for (int i = 0; i < s.length(); i++) {
      String curr = s.substring(i, i+1);
      if (Operator.isOperator(curr)) break;
      try {
        Double.parseDouble(curr);
      } catch (Exception e) {
        System.out.printf("Invalid digit: '%s'", curr);
        System.exit(1);
      }
      digit += curr;
    }
    return new Digit(digit);
  }

  void insert(Node n) {
    if (this.left == null) {
      this.left = n;
    } else if (this.right == null){
      this.right = n;
    } else {
      System.out.println("Failet ganske hardt");
      System.exit(1);
    }
  }

  @Override
  public int compareTo(Node other) {
    return -1;
  }
}
