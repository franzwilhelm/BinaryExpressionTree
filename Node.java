abstract class Node<T> {
  Node left;
  Node right;
  T value;

  Node(T value) {
    this.value = value;
  }

  void insert(Node n) throws Exception {
    if (this.left == null) {
      this.left = n;
    } else if (this.right == null){
      this.right = n;
    } else {
      throw new Exception("Failed AF");
    }
  }

  abstract int calculate(Digit a, Digit b);
}

class Operator extends Node {
  Operator(String value) {
    super(value);
  }

  int calculate(Digit a, Digit b) {


  }

}

class Digit extends Node {
  Digit(int value) {
    super(value);
  }

  int calculate(Digit a, Digit b) {
    System.out.println("Cannot calculate with root digit");
    System.exit(1);
  }
}
