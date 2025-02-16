import java.util.*;
public class SaleDiscount {
    static String[] products = {"Laptop", "Phone", "Tablet", "Headphones", "Smartwatch", "Monitor", "Keyboard", "Mouse", "Speaker", "Power Bank"};
    static double[] prices = {800, 500, 300, 100, 200, 250, 50, 30, 150, 40};
    static int[] stock = {25, 10, 8, 15, 12, 7, 20, 18, 9, 14}; // Stock for each product
    static double totalSales = 0;

    static List<String> purchasedProducts = new ArrayList<>();
    static List<Double> purchasedPrices = new ArrayList<>();
    static List<Double> purchasedDiscounts = new ArrayList<>();
    static List<Double> finalAmounts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n======= Option =======");
            System.out.println("1. View All Products");
            System.out.println("2. Purchas Product");
            System.out.println("3. View Purchase Information");
            System.out.println("4. View Total Sales");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    buyProduct(scanner);
                    break;
                case 3:
                    viewPurchaseInformation();
                    break;
                case 4:
                    viewTotalSales();
                    break;
                case 5:
                    System.out.println("Exiting program... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }

    public static void viewProducts() {
        System.out.println("\n=========== Available Products ===========");
        System.out.printf("%-5s %-15s %-10s %-8s\n", "No.", "Product", "Price($)", "Stock");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%-5d %-15s $%-9.2f %-8d\n", (i + 1), products[i], prices[i], stock[i]);
        }
    }

    public static void buyProduct(Scanner scanner) {
        viewProducts();
        System.out.print("\nEnter product number to buy: ");
        int productNumber = scanner.nextInt();

        if (productNumber >= 1 && productNumber <= products.length) {
            int index = productNumber - 1;

            if (stock[index] > 0) {
                double price = prices[index];
                double discountPercentage = getDiscountPercentage(price);
                double discountAmount = (discountPercentage / 100) * price;
                double finalPrice = price - discountAmount;
                
                purchasedProducts.add(products[index]);
                purchasedPrices.add(price);
                purchasedDiscounts.add(discountAmount);
                finalAmounts.add(finalPrice);
                
                totalSales += finalPrice;
                stock[index]--;
                
                System.out.println(" You Purchas " + products[index] + "  successfully!");
            } else {
                System.out.println(" Sorry, this product is out of stock!");
            }
        } else {
            System.out.println("\nInvalid product selection.");
        }
    }

    public static double getDiscountPercentage(double price) {
        if (price >= 1 && price <= 50) return 5;
        else if (price > 50 && price <= 100) return 10;
        else if (price > 100 && price <= 300) return 15;
        else if (price > 300 && price <= 600) return 20;
        else if (price > 600 && price <= 1000) return 25;
        else if (price > 1000 && price <= 5000) return 30;
        else if (price > 5000 && price <= 7000) return 40;
        else  return 45;
    }

    public static void viewPurchaseInformation() {
        System.out.println("\n============ Purchase History ============");
        if (purchasedProducts.isEmpty()) {
            System.out.println(" No purchases made yet.");
            return;
        }
        
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Product", "Price ($)", "Discount ($)", "Final Price ($)");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < purchasedProducts.size(); i++) {
            System.out.printf("%-15s $%-9.2f $%-9.2f $%-9.2f\n", 
                              purchasedProducts.get(i), 
                              purchasedPrices.get(i), 
                              purchasedDiscounts.get(i), 
                              finalAmounts.get(i));
        }
    }

    public static void viewTotalSales() {
        System.out.println("\nTotal Sales: $" + totalSales);
    }
}
