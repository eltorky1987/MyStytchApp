import java.util.Scanner;

public class MainActivity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("🛒 --- Agina Digital Store --- 🛒");
        
        System.out.print("📦 Enter Product Name: ");
        String product = input.nextLine();
        
        System.out.print("💰 Enter Unit Price (EGP): ");
        double price = input.nextDouble();
        
        System.out.print("🔢 Enter Quantity: ");
        int qty = input.nextInt();
        
        double total = price * qty;
        
        System.out.println("\n----------------------------");
        System.out.println("🧾 INVOICE FOR: " + product);
        System.out.println("💵 Price: " + price + " EGP");
        System.out.println("📦 Quantity: " + qty);
        System.out.println("----------------------------");
        System.out.println("💎 TOTAL AMOUNT: " + total + " EGP");
        System.out.println("----------------------------");
        System.out.println("Developer: Agina tork");
    }
}
