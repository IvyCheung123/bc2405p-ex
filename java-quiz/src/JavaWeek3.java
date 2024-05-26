public class JavaWeek3 {
  public static void main(String[] args) {
    // Question 1
    int price = 150;
    int quantity = 10;
    // int discount = 0.9; // Type mismatch: cannot convert from double to int
    double discount = 0.9;
    System.out.println("Question 1 = " + price * quantity * discount); // 1350.0

    // Question 2
    byte hoursOfDay = 24;
    byte daysOfWeek = 7;
    byte hoursOfWeek = (byte) (hoursOfDay * daysOfWeek);
    System.out.println("Question 2 = " + hoursOfWeek); // 24 * 7 = 168 -> -88
    // byte (-128 to 127)
    // Positive = -128 + (n - 127) - 1
    // e.g. -128 + (168 - 127) - 1 = -88
    // Negative = -88 -> 88 if n is -168

    // Question 3
    String str = "Welcome to programming";
    String newStr = str.replace("WELCOME TO", ""); // "Welcome yo programming"
    char c = newStr.trim().charAt(2); // "Welcome yo programming"
    System.out.println("Question 3 = " + c); // l

    // Question 4
    String s = "hello"; // s.length() = 5
    // s.indexOf("h") = 0
    // s.indexOf("e") = 1
    // s.indexOf("l") = 2
    // s.indexOf("o") = 4
    // s.indexOf("he") = 0
    // s.indexOf("el") = 1
    // s.indexOf("ll") = 2
    // s.indexOf("lo") = 3
    // s.indexOf("ello") = 1
    String newS = "";
    if (s.length() > 5 || s.indexOf("he") == 1) { // false || false -> false
      newS = s;
    } else {
      newS += "str";
    }
    System.out.println("Question 4 = " + newS); // str

    // Question 5
    String str2 = "";
    for (byte i = 127; i < 128; i++) { // 127 128 -> -128
      // byte (-128 to 127)
      str2 += i;
      if (i < 0) {
        break;
      }
    }
    System.out.println("Question 5 = " + str2); // 127-128

    /*
    String str3 = "";
    for (byte i = 127; i < 129; i++) { // if detect i > 127, will automatically loop to -128
      str3 += i;
      System.out.println(str3);
    }
    */

    // Question 6
    /*
    String str3 = "";
    for (byte i = 127; i < 128; i++) { // 127 -128 ... back to 127 to -128 (-128 to 127)
      if (i < 0) {
        continue;
      }
      str3 += i;
    }
    System.out.println(str3); // infinite loop
    // i < 128 = infinite loop
    // i < -128 = empty line
    */
    
    // Question 7
    int[] integers = {20, 10, 40};
    byte[] bytes = new byte[] {2, 4, 1};
    int score = 0;
    for (int i = 0; i < 3; i++) { // 0 1 2
      if (i % 2 == 1) {
        score += integers[i];
      } else {
        score += bytes[i];
      }
    }
    System.out.println("Question 7 = " + score); // 2 + 10 + 1 = 13

    // Question 8
    /*
    String[] strings = new String[3];
    String sum = "";
    for (int i = 0; i < 4; i++) { // 0 1 2 3
      strings[i] = String.valueOf(i);
      sum += strings[i];
    }
    System.out.println(sum); // runtime error
    */
    String[] strings = new String[3];
    String sum = "";
    for (int i = 0; i < 3; i++) { // 0 1 2
      strings[i] = String.valueOf(i);
      sum += strings[i];
    }
    System.out.println("Question 8 (optional) = " + sum); // 012
    
    String[] strs = new String[] {"10", "11", "12"};
    String sums = "";
    for (int i = 0; i < 3; i++) { // 0 1 2
      strs[i] = String.valueOf(i); // what is valueOf()?
      sums += strs[i];
    }
    System.out.println("Question 8 (optional) = " + sums); // 012
    
    // Question 9
    System.out.println("Question 9 = ");
    int a = 0;
    while (a < 3) { // 0 1 2
      switch (a) {
        case 0:
        System.out.println("0");
        case 2:
        System.out.println("2");
      }
      a++;
    } // 022
    System.out.println("Question 9 (optional) = ");
    int a2 = 0;
    while (a2 < 3) { // 0 1 2
      switch (a2) {
        case 0:
        System.out.println("0");
        break;
        case 2:
        System.out.println("2");
        break;
      }
      a2++;
    } // 02

    // Question 10
    int g = 3;
    System.out.println("Question 10 = " + ++g * 8); // 4 * 8 = 32

    // My Ans:      1C 2A 3D 4A 5A 6A 7D 8D 9C 10A
    // Correct Ans: 1B 2A 3D 4A 5B 6D 7D 8C 9B 10A
  }
}
