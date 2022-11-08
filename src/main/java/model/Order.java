package model;

public class Order extends Product {

    private int orderId;
    private int userID;
    private int quantity;
    public Order() {
    }

    public Order(int orderId, int userID, int quantity) {
        this.orderId = orderId;
        this.userID = userID;
        this.quantity = quantity;
    }

    public Order(int idProduct, String nameProduct, int price, int calo, int quantity, String img, int status, String detail, int orderId, int userID, int quantity1) {
        super(idProduct, nameProduct, price, calo, quantity, img, status, detail);
        this.orderId = orderId;
        this.userID = userID;
        this.quantity = quantity1;
    }

    public Order(String nameProduct, int price, int calo, int quantity, String img, int status, String detail, int orderId, int userID, int quantity1) {
        super(nameProduct, price, calo, quantity, img, status, detail);
        this.orderId = orderId;
        this.userID = userID;
        this.quantity = quantity1;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
