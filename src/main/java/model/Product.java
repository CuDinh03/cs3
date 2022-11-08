package model;

public class Product {
    private int idProduct;
    private String nameProduct;
    private int price;
    private int calo;
    private int quantity;
    private String img;
    private int status;
    private String detail;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, int price, int calo, int quantity, String img, int status, String detail) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.calo = calo;
        this.quantity = quantity;
        this.img = img;
        this.status = status;
        this.detail = detail;
    }

    public Product(String nameProduct, int price, int calo, int quantity, String img, int status, String detail) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.calo = calo;
        this.quantity = quantity;
        this.img = img;
        this.status = status;
        this.detail = detail;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCalo() {
        return calo;
    }

    public void setCalo(int calo) {
        this.calo = calo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", calo=" + calo +
                ", quantity=" + quantity +
                ", img='" + img + '\'' +
                ", status=" + status +
                ", detail='" + detail + '\'' +
                '}';
    }
}
