import java.util.HashMap;
import java.util.Scanner;
class Product {
    String name;
    double price;
    boolean isRecharge;

    Product(String name, double price, boolean isRecharge) {
        this.name = name;
        this.price = price;
        this.isRecharge = isRecharge;
    }
}
public class SmartShoppingRFID {
	static HashMap<String, Product> productDB = new HashMap<>();
    public static void main(String[] args) {
        productDB.put("07103", new Product("Rice", 50, false));
        productDB.put("25348", new Product("Milk", 25, false));
        productDB.put("29723", new Product("Bread", 30, false));
        productDB.put("28574", new Product("Sugar", 45, false));
        productDB.put("50270", new Product("Mobile Recharge ₹100", 100, true));
        productDB.put("61204", new Product("Mobile Recharge ₹200", 200, true));
        Scanner sc = new Scanner(System.in);
        double total = 0;
        System.out.println("===== Smart Shopping Billing System =====");
        while (true) {
            System.out.print("\nScan RFID Tag (Enter ID or 0 to Exit): ");
            String tag = sc.nextLine();
            if (tag.equals("0")) break;
            if (productDB.containsKey(tag)) {
                Product p = productDB.get(tag);
                if (p.isRecharge) {
                    System.out.println("Recharge Card Detected!");
                } else {
                    System.out.println("Product Detected!");
                }
                System.out.println("Item: " + p.name);
                System.out.println("Price: ₹" + p.price);
                total += p.price;
            } else {
                System.out.println("Invalid RFID Tag!");
            }
        }
        System.out.println("\n===== FINAL BILL =====");
        System.out.println("Total Amount: ₹" + total);
        System.out.println("Thank You for Shopping!");
        sc.close();
    }	
}