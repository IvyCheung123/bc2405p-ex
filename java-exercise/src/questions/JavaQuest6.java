public class JavaQuest6 {
  /**
   * Expected output:
   * 1 1 2 3 5 8 13 21 ...
   * 
   */
  // Count the target of character in a String.
  public static void main(String[] args) {
    // Code here ...
    // for loop to print first 15 numbers in Fibonacci Sequence
    int a = 0;
    int b = 1;
    System.out.println(b);
    for (int i = 0; i < 14; i++) {
      int sum = a + b;
      System.out.println(sum);
      a = b;
      b = sum;
    }
  }
}