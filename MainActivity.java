import java.util.Scanner;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainActivity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String secretKey = "agina@2026";
        
        System.out.println("🚀 --- AGINA PRO SALES SYSTEM v2.1 --- 🚀");
        System.out.print("🔑 Access Key: ");
        if (!input.nextLine().equals(secretKey)) {
            System.out.println("❌ Access Denied!"); return;
        }

        while (true) {
            System.out.println("\n[1] Record Sale  [2] View Reports  [3] Exit");
            System.out.print("Action: ");
            String choice = input.next();

            if (choice.equals("1")) {
                System.out.print("Product: "); String item = input.next();
                double price = 0;
                
                // نظام حماية السعر (منع الانهيار)
                boolean validPrice = false;
                while (!validPrice) {
                    System.out.print("Price: ");
                    try {
                        price = Double.parseDouble(input.next());
                        validPrice = true;
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ Error: Please enter numbers only for price!");
                    }
                }
                
                String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                try (FileWriter fw = new FileWriter("database.csv", true)) {
                    fw.write(time + "," + item + "," + price + "\n");
                    System.out.println("✅ Transaction Secured!");
                } catch (IOException e) { System.out.println("⚠️ Storage Error!"); }

            } else if (choice.equals("2")) {
                System.out.println("\n--- Opening Database ---");
                try (BufferedReader br = new BufferedReader(new FileReader("database.csv"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line.replace(",", " | "));
                    }
                } catch (IOException e) { System.out.println("No records found."); }
                
            } else if (choice.equals("3")) {
                System.out.println("Powering off... See you, Agina!");
                break;
            }
        }
    }
}
