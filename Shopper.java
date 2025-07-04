public class Shopper {
    private String name;
    private double balance;

    public Shopper(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deductBalance(double amount) {
        this.balance -= amount;
    }
}
