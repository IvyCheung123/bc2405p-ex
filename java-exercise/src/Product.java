import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Product {

  // Attributes
  private String name;
  private LocalDate mfg;
  private char[] id;
  private double listedPrice;
  private double discount;
  
  // Constructors
  public Product() {

  }

  public Product(String name, LocalDate mfg, char[] id, double listedPrice, double discount) {
    this.name = name;
    this.mfg = mfg;
    this.id = id;
    this.listedPrice = listedPrice;
    this.discount = discount;
  }

  // Setter
  public void setName(String name) {
    this.name = name;
  }

  public void setMfg(LocalDate mfg) {
    this.mfg = mfg;
  }

  public void setId(char[] id) {
    this.id = id;
  }

  public void setListedPrice(double listedPrice) {
    this.listedPrice = listedPrice;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  // Getter
  public String getName() {
    return this.name;
  }

  public LocalDate getMfg() {
    return this.mfg;
  }

  public char[] getId() {
    return this.id;
  }

  public double getListedPrice() {
    return this.listedPrice;
  }

  public double getDiscount() {
    return this.discount;
  }

  public String getSellingPrice() {
    return "Selling Price for " + this.name + ": $" + this.productCalculator();
  }

  // Instance Method
  public double productCalculator() {
    return BigDecimal.valueOf(this.listedPrice)
    .multiply(BigDecimal.valueOf(1 - this.discount))
    .doubleValue();
  }

  // toString()
  public String toString() {
    return "Name: " + this.name +
    ", MFG: " + this.mfg +
    ", ID: " + Arrays.toString(this.id) +
    ", Listed Price: $" + this.listedPrice +
    ", Discount: " + this.discount;
  }

  // Static Method
  public static double yourCalculator(double listedPrice, double discount) {
    return BigDecimal.valueOf(listedPrice)
    .multiply(BigDecimal.valueOf(1 - discount))
    .doubleValue();
  }

  public static void main(String[] args) {
    char[] milkId = new char[] {'0', '0', '1'};
    Product milk = new Product("Milk", LocalDate.of(2024, 6, 9), milkId, 7.0, 0.1);
    System.out.println(milk.toString());
    System.out.println(milk.getSellingPrice());

    char[] breadId = new char[] {'0', '0', '2'};
    Product bread = new Product("Bread", LocalDate.of(2024, 6, 8), breadId, 15.5, 0.2);
    System.out.println(bread.toString());
    System.out.println(bread.getSellingPrice());

    // Change the discount on bread
    bread.setDiscount(0.4);
    System.out.println(bread.toString());
    System.out.println(bread.getSellingPrice());

    // Check the selling price on your calculator
    Scanner scanner = new Scanner(System.in);
    System.out.print("Please enter an existing product you want to check: ");
    String name = scanner.nextLine();
    System.out.print("Please enter its listed price: $");
    double listedPrice = scanner.nextDouble();
    System.out.print("Please enter its discount: ");
    double discount = scanner.nextDouble();
    System.out.println("The selling price for this product (" + name + ") is $" + Product.yourCalculator(listedPrice, discount));
    scanner.close();
  }
}
