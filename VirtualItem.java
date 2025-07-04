
public class VirtualItem extends Item {
    public VirtualItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    public boolean isShippable() {
        return false;
    }

    public boolean isExpired() {
        return false;
    }

}