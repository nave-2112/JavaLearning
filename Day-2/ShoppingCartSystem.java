class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

   

    public String toString() {
        return name + " (x" + quantity + ") - " + String.format("%.2f", price);
    }
}


class Cart {
    Product[] products;
    int productCount;  
    public Cart(int maxSize) {
        this.products = new Product[maxSize];
        this.productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount >= products.length) {
            System.out.println("Cart is full");
            return;
        }

        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equals(product.getName())) {
                products[i].setQuantity(products[i].getQuantity() + product.getQuantity());
                return;
            }
        }
        products[productCount] = product;
        productCount++;
    }
    public void removeProduct(String productName) {
        boolean found = false;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equals(productName)) {
                for (int j = i; j < productCount - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[productCount - 1] = null;  
                productCount--;
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product '" + productName + "' not found in cart.");
        }
    }


    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < productCount; i++) {
            total += products[i].getPrice() * products[i].getQuantity();
        }
        return total;
    }
    public String toString() {
        if (productCount == 0) {
            return "Cart is empty.";
        }

        StringBuilder cartDetails = new StringBuilder("Cart contains:\n");
        for (int i = 0; i < productCount; i++) {
            cartDetails.append(products[i]).append("\n");
        }
        cartDetails.append("Total: ").append(String.format("%.2f", calculateTotal()));
        return cartDetails.toString();
    }
}


public class ShoppingCartSystem {
    public static void main(String[] args) {
        
        Product apple = new Product("Apple", 10.2, 3);  
        Product banana = new Product("Banana", 20.5, 5);  
        Product orange = new Product("Orange", 30.8, 2);  

        
        Cart cart = new Cart(10);
        cart.addProduct(apple);
        cart.addProduct(banana);
        cart.addProduct(orange);
        System.out.println(cart);
        cart.addProduct(new Product("Apple", 1.2, 2));
        System.out.println("\nAfter adding more apples:");
        System.out.println(cart);
        cart.removeProduct("Banana");
        System.out.println("\nAfter removing bananas:");
        System.out.println(cart);
        double total = cart.calculateTotal();
        System.out.println("\nTotal price of all items: " + String.format("%.2f", total));
    }
}