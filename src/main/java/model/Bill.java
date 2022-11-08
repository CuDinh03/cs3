package model;

public class Bill {
    private int  idBill;
    private int idProduct;
    private int idUser;
    private int idCart;
    private int priceBill;
    private String detail;

    public Bill() {
    }

    public Bill(int idBill, int idProduct, int idUser, int idCart, int priceBill, String detail) {
        this.idBill = idBill;
        this.idProduct = idProduct;
        this.idUser = idUser;
        this.idCart = idCart;
        this.priceBill = priceBill;
        this.detail = detail;
    }

    public Bill(int idProduct, int idUser, int idCart, int priceBill, String detail) {
        this.idProduct = idProduct;
        this.idUser = idUser;
        this.idCart = idCart;
        this.priceBill = priceBill;
        this.detail = detail;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getPriceBill() {
        return priceBill;
    }

    public void setPriceBill(int priceBill) {
        this.priceBill = priceBill;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
