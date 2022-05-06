package store;

public class Product {
    private String name;
    private int amount;
    private boolean date = true;

    public Product(String name, int amount, boolean date) {
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    public String getName() {
        return this.name;
    }

    public boolean getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return name + " в количестве " + amount + " штук";
    }
}
