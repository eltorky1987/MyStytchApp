import java.util.Scanner;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainActivity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String secretKey = "agina@2026";
        
        System.out.println("🚀 --- AGINA PRO SALES SYSTEM v2.0 --- 🚀");
        System.out.print("🔑 Access Key: ");
        if (!input.nextLine().equals(secretKey)) {
            System.out.println("❌ Access Denied!"); return;
        }

        while (true) {
            System.out.println("\n[1] Record New Sale  [2] Export Excel (CSV)  [3] Exit");
            System.out.print("Action: ");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.print("Product: "); String item = input.next();
                System.out.print("Price: "); double price = input.nextDouble();
                
                // إضافة التاريخ والوقت
                String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                
                try (FileWriter fw = new FileWriter("database.csv", true)) {
                    fw.write(time + "," + item + "," + price + "\n");
                    System.out.println("✅ Transaction Secured in Database!");
                } catch (IOException e) { System.out.println("⚠️ Storage Error!"); }

            } else if (choice == 2) {
                System.out.println("\n--- Opening Database ---");
                try (BufferedReader br = new BufferedReader(new FileReader("database.csv"))) {
                    String line;
                    System.out.println("Date & Time | Item | Price");
                    while ((line = br.readLine()) != null) {
                        System.out.println(line.replace(",", " | "));
                    }
                } catch (IOException e) { System.out.println("No records found."); }
                
            } else if (choice == 3) {
                System.out.println("Shutting down... Goodbye Agina!");
                break;
            }
        }
    }
}
