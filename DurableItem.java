public class DurableItem extends Item implements Transportable {
    private double weight;

    public DurableItem(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isShippable() {
        return true;
    }

    public boolean isExpired() {
        return false;
    }

}