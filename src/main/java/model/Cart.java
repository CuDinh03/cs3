package model;

public class Cart extends Product {

    private int quantity;

    private int id;
    private double totalPrice;
    private int amount;


    public Cart() {
    }

    public Cart(int quantity, int id, double totalPrice) {
        this.quantity = quantity;
        this.id = id;
        this.totalPrice = totalPrice;
    }

    public Cart(int quantity, int id, double totalPrice, int amount) {
        this.quantity = quantity;
        this.id = id;
        this.totalPrice = totalPrice;
        this.amount = amount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
