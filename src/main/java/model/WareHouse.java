package model;

public class WareHouse {
   private int  idWareHouse;
   private int  idProduct;
   private Boolean  status;
   private String  detail;

   private int quantity;

    public WareHouse() {
    }

    public WareHouse(int idWareHouse, int idProduct, Boolean status, String detail, int quantity) {
        this.idWareHouse = idWareHouse;
        this.idProduct = idProduct;
        this.status = status;
        this.detail = detail;
        this.quantity = quantity;
    }

    public int getIdWareHouse() {
        return idWareHouse;
    }

    public void setIdWareHouse(int idWareHouse) {
        this.idWareHouse = idWareHouse;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
