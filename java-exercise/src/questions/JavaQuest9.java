/**
 * Expected Output:
 * J
 * e
 * 3
 * 9
 * 10
 * ab c
 * VenturenixLAB, Coding
 * 19
 * ren
 * VENTURENIXLAB, JAVA
 * venturenixlab, java
 * V*NTUR*NIXLAB, JAVA!!!
 */
public class JavaQuest9 {
  public static void main(String[] args) {
    String str = "VenturenixLAB, Java";

    // prints J
    char target = 'J';
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == target) {
        System.out.println(str.charAt(i));
        break;
      }
    }

    // prints e (the 1st e)
    // code here ...
    target = 'e';
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == target) {
        System.out.println(str.charAt(i));
        break;
      }
    }

    // Use indexOf()
    // prints 3
    // prints 9
    // prints 10
    // code here ...
    System.out.println(str.indexOf("t"));
    System.out.println(str.indexOf("x"));
    System.out.println(str.indexOf("L"));

    // Use String trim()
    String abc = "    ab c    ";
    // prints "ab c"
    System.out.println(abc.trim());

    // Use String replace() method
    // prints VenturenixLAB, Coding
    // code here ...
    System.out.println(str.replace("Java", "Coding"));

    // int length()
    // prints 19
    // code here ...
    System.out.println(str.length());

    // Use String substring(int start, int end)
    // prints "ren"
    // code here ...
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == 'r' && str.charAt(i + 1) == 'e' && str.charAt(i + 2) == 'n') {
        System.out.println(str.substring(i, i + 3));
        break;
      }
    }

    // print "VENTURENIXLAB, JAVA"
    // prints "venturenixlab, java"
    // code here ...
    System.out.println(str.toUpperCase());
    System.out.println(str.toLowerCase());

    // Method Chaining (one line to complete)
    // prints "V*NTUR*NIXLAB, JAVA!!!"
    // code here ...
    System.out.println(str.toUpperCase().replace("E", "*") + "!!!");
  }
}