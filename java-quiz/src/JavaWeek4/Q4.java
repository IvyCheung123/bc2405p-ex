package JavaWeek4;

public class Q4 {
  private String password;

  public Q4(String x) {
    this.password = x;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void append(Q4 password) {
    password.setPassword("XYZ");
    this.password = "BCD";
  }

  public static void main(String[] args) {
    Q4 p1 = new Q4("ABC");
    Q4 p2 = new Q4("BCD");
    p1.append(p2);
    System.out.println(p1.getPassword() + p2.getPassword()); // BCDXYZ
  }
}
