import java.util.*;

public class Main {
    public static void main(String[] args) {
        Shopper customer = new Shopper("Abdalla", 1000);

        Item cheese = new PerishableItem("Cheese", 100, 5,
                new GregorianCalendar(2025, Calendar.DECEMBER, 1).getTime(), 0.2);
        Item biscuits = new PerishableItem("Biscuits", 150, 3,
                new GregorianCalendar(2025, Calendar.DECEMBER, 1).getTime(), 0.7);
        Item tv = new DurableItem("TV", 300, 4, 3.0);
        Item scratchCard = new VirtualItem("Mobile Scratch Card", 50, 10);

        ShoppingBasket cart = new ShoppingBasket();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(tv, 1);
        cart.add(scratchCard, 1);

        PaymentProcessor.checkout(customer, cart);
    }
}
