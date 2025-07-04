import java.util.Date;

public class PerishableItem extends Item implements Transportable {
    private Date expiryDate;
    private double weight;

    public PerishableItem(String name, double price, int quantity, Date expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    public boolean isExpired() {
        return new Date().after(expiryDate);
    }

    public boolean isShippable() {
        return true;
    }

    public double getWeight() {
        return weight;
    }
}
