import java.util.*;

abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity(int qty) {
        this.quantity -= qty;
    }

    public abstract boolean isExpired();

    public abstract boolean isShippable();
}

public class Main {
    public static void main(String[] args) {

        // Add items to cart
        // Cart cart = new Cart();
        // cart.add(cheese, 2);
        // cart.add(biscuits, 1);
        // cart.add(tv, 1);
        // cart.add(scratchCard, 1);

        // Process checkout
        // CheckoutService.checkout(customer, cart);

    }
}