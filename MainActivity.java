import java.util.Scanner;

public class MainActivity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("💎 --- Agina Premium Store --- 💎");
        
        System.out.print("📦 Product: ");
        String product = input.nextLine();
        
        System.out.print("💰 Price: ");
        double price = input.nextDouble();
        
        System.out.print("🔢 Qty: ");
        int qty = input.nextInt();
        
        double subtotal = price * qty;
        double discount = 0;
        
        if (subtotal >= 1000) {
            discount = subtotal * 0.10; // خصم 10%
        }
        
        double finalTotal = subtotal - discount;
        
        System.out.println("\n--- 🧾 FINAL INVOICE ---");
        System.out.println("Product: " + product);
        System.out.println("Subtotal: " + subtotal + " EGP");
        if (discount > 0) {
            System.out.println("🔥 Discount (10%): -" + discount + " EGP");
        }
        System.out.println("💰 TOTAL: " + finalTotal + " EGP");
        System.out.println("------------------------");
        System.out.println("Developer: Agina (Master of Java)");
    }
}
