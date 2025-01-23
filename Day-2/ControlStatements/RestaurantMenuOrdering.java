import java.util.Scanner;

public class RestaurantMenuOrdering {
    public static void main(String[] args) {
        String[] menuItems = {"Pizza", "Burger", "Noodles", "Manchuria", "shawarma"};
        double[] prices = {200, 349, 299, 399, 199};
        
        Scanner sc = new Scanner(System.in);
        double totalCost = 0;
        StringBuilder orderDetails = new StringBuilder();

        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + ". " + menuItems[i] + " - " + prices[i]);
        }
    
        while (true) {
            System.out.print("\nEnter the  item you want to order: ");
            int itemChoice = sc.nextInt();
            if (itemChoice == 0) {
                break;
            }
            if (itemChoice < 1 || itemChoice > menuItems.length) {
                System.out.println("Invalid choice");
                continue;
            }
            int itemIndex = itemChoice - 1;
            orderDetails.append(menuItems[itemIndex]).append(" - ").append(prices[itemIndex]).append("\n");
            totalCost += prices[itemIndex];
            
            System.out.println(menuItems[itemIndex] + " added to cart");
        }

        System.out.println(orderDetails);
        System.out.println("Total cost: " + totalCost);

    }
}