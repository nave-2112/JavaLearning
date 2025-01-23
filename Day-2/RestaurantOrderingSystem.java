import java.util.Scanner;
class MenuItem {
    String itemName;
    double itemPrice;
    String itemCategory;
    public MenuItem(String itemName, double itemPrice, String itemCategory) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCategory = itemCategory;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getItemCategory() {
        return itemCategory;
    }


    public void displayItem() {
        System.out.println(itemName + " - " + itemCategory + " - " + String.format("%.2f", itemPrice));
    }
}

class Restaurant {
    MenuItem[] menuItems;
    int orderCount;
    double totalBill;
    public Restaurant() {
        
        menuItems = new MenuItem[] {
            new MenuItem("Manchuria", 70, "Main Course"),
            new MenuItem("Noodles", 80, "Main Course"),
            new MenuItem("Shawarma", 100, "Main Course"),
            new MenuItem("salad", 50, "Salad"),
            new MenuItem("chilli chicken", 120, "Side Dish"),
            new MenuItem("Thumbs", 20, "Cool Drink"),
            new MenuItem("Gulab Jam", 30, "Dessert")
        };
        orderCount = 0;
        totalBill = 0;
    }
    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menuItems.length; i++) {
            menuItems[i].displayItem();
        }
    }

    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        boolean ordering = true;

        while (ordering) {
            System.out.print("Enter the number of the item you'd like to order (1-" + menuItems.length + "), or 0 to finish: ");
            int itemNumber = scanner.nextInt();

            if (itemNumber == 0) {
                ordering = false;
                System.out.println("Your order has been finalized.");
            } else if (itemNumber >= 1 && itemNumber <= menuItems.length) {
                
                MenuItem selectedItem = menuItems[itemNumber - 1];

                System.out.print("How many " + selectedItem.getItemName() + "(s) would you like? ");
                int quantity = scanner.nextInt();

                
                double itemTotalPrice = selectedItem.getItemPrice() * quantity;
                totalBill += itemTotalPrice;
                System.out.println(quantity + " x " + selectedItem.getItemName() + " - " + String.format("%.2f", itemTotalPrice));

                orderCount++;
            } else {
                System.out.println("Invalid option, please choose a valid menu item number.");
            }
        }
    }


    public void displayBill() {
        System.out.println("\n--- Bill ---");
        System.out.println("Total number of items ordered: " + orderCount);
        System.out.println("Total Bill: " + String.format("%.2f", totalBill));
    }
}


public class RestaurantOrderingSystem {
    public static void main(String[] args) {
        
        Restaurant restaurant = new Restaurant();
        restaurant.displayMenu();
        restaurant.takeOrder();
        restaurant.displayBill();
    }
}