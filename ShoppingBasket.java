import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private List<CartEntry> items = new ArrayList<>();

    public void add(Item product, int qty) {
        if (qty > product.getQuantity()) {
            throw new IllegalArgumentException("Not enough stock for " + product.getName());
        }
        items.add(new CartEntry(product, qty));
    }

    public List<CartEntry> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
