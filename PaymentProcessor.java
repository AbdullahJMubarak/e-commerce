import java.util.*;

public class PaymentProcessor {
    public static void checkout(Shopper customer, ShoppingBasket cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }

        double subtotal = 0;
        double shippingFee = 0;
        List<Transportable> shippableItems = new ArrayList<>();

        for (CartEntry item : cart.getItems()) {
            Item product = item.product;

            if (product.isExpired()) {
                throw new IllegalStateException(product.getName() + " has expired.");
            }

            if (item.quantity > product.getQuantity()) {
                throw new IllegalStateException("Stock insufficient for " + product.getName());
            }

            subtotal += product.getPrice() * item.quantity;

            if (product.isShippable()) {
                for (int i = 0; i < item.quantity; i++) {
                    shippableItems.add((Transportable) product);
                }
                shippingFee += 10.0;
            }
        }

        double total = subtotal + shippingFee;

        if (customer.getBalance() < total) {
            throw new IllegalStateException("Insufficient funds.");
        }

        for (CartEntry item : cart.getItems()) {
            item.product.reduceQuantity(item.quantity);
        }

        DeliveryManager.ship(shippableItems);

        System.out.println("\n** Checkout Receipt **");
        for (CartEntry item : cart.getItems()) {
            System.out.printf("%dx %s = %.2f\n", item.quantity, item.product.getName(),
                    item.product.getPrice() * item.quantity);
        }
        System.out.println("---------------------------");
        System.out.printf("Subtotal: %.2f\n", subtotal);
        System.out.printf("Shipping: %.2f\n", shippingFee);
        System.out.printf("Total:    %.2f\n", total);

        customer.deductBalance(total);
        System.out.printf("Remaining Balance: %.2f\n", customer.getBalance());
    }
}
