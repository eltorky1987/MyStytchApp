import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // دي الباسورد السرية بتاعتك يا أجينا
        String secretKey = "agina@2026"; 
        
        System.out.println("🛡️ --- Agina Secure Terminal --- 🛡️");
        System.out.print("🔑 Enter Admin Password: ");
        String enteredPass = input.nextLine();
        
        // التحقق من الباسورد
        if (enteredPass.equals(secretKey)) {
            System.out.println("✅ Access Granted! Welcome Master Agina.");
            System.out.println("---------------------------------------");
            
            System.out.print("📦 Product Name: ");
            String product = input.nextLine();
            
            System.out.print("💰 Price: ");
            double price = input.nextDouble();
            
            // تسجيل البيانات في ملف sales_report.txt
            try {
                FileWriter writer = new FileWriter("sales_report.txt", true);
                writer.write("Product: " + product + " | Price: " + price + " EGP\n");
                writer.close();
                System.out.println("💾 Data secured and saved to sales_report.txt");
            } catch (IOException e) {
                System.out.println("⚠️ Storage Error!");
            }
            
        } else {
            System.out.println("❌ ERROR: Unauthorized Access!");
            System.out.println("Identity verification failed.");
        }
    }
}
