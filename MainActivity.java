import java.util.Scanner;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainActivity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String secretKey = "agina@2026";
        
        System.out.println("🚀 --- AGINA SMART ACCOUNTANT v2.2 --- 🚀");
        System.out.print("🔑 Access Key: ");
        if (!input.nextLine().equals(secretKey)) {
            System.out.println("❌ Access Denied!"); return;
        }

        while (true) {
            System.out.println("\n[1] Record Sale  [2] Total Earnings  [3] Full Report  [4] Exit");
            System.out.print("Action: ");
            String choice = input.next();

            if (choice.equals("1")) {
                System.out.print("Product Name: "); String item = input.next();
                double price = 0;
                boolean validPrice = false;
                while (!validPrice) {
                    System.out.print("Price (EGP): ");
                    try {
                        price = Double.parseDouble(input.next());
                        validPrice = true;
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ Error: Numbers only!");
                    }
                }
                String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                try (FileWriter fw = new FileWriter("database.csv", true)) {
                    fw.write(time + "," + item + "," + price + "\n");
                    System.out.println("✅ Transaction Recorded!");
                } catch (IOException e) { System.out.println("⚠️ Storage Error!"); }

            } else if (choice.equals("2")) {
                double total = 0;
                try (BufferedReader br = new BufferedReader(new FileReader("database.csv"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] data = line.split(",");
                        total += Double.parseDouble(data[2]);
                    }
                    System.out.println("\n💰 TOTAL REVENUE: " + total + " EGP");
                } catch (Exception e) { System.out.println("No sales found yet."); }

            } else if (choice.equals("3")) {
                System.out.println("\n--- 📋 SALES LOG REPORT ---");
                System.out.println("Date | Time | Product | Price");
                try (BufferedReader br = new BufferedReader(new FileReader("database.csv"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line.replace(",", " | "));
                    }
                } catch (IOException e) { System.out.println("Empty database."); }

            } else if (choice.equals("4")) {
                System.out.println("System Log-off. Stay legendary, Agina!");
                break;
            }
        }
    }
}
