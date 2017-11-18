class Main {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Run with Main [expression]");
      System.exit(1);
    }
    MathTree m = new MathTree(args[0]);
    System.out.println(m);
    System.out.println(m.calculate());
  }
}
