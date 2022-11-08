package dao;

import model.Order;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private Connection connection;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public OrderDao(Connection connection) {
        super();
        this.connection = connection;
    }

    public boolean insertOrder(Order model) {
        boolean result = false;
        try {
            query = "insert into orders (oid, uid, quantity) values(?,?,?) ";
            pst = this.connection.prepareStatement(query);
            pst.setInt(1, model.getOrderId());
            pst.setInt(2, model.getUserID());
            pst.setInt(3, model.getQuantity());
            pst.executeUpdate();
            result = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public List<Order> userOrders(int id) {
        List<Order> list = new ArrayList<>();
        try {
            query = "select * from orders where uid=? order by orders.oid desc";
            pst = this.connection.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                CRUD_Product CRUD_Product = new CRUD_Product(this.connection);
                int pId = rs.getInt("idProduct");
                Product product = CRUD_Product.getSingleProduct(pId);
                order.setOrderId(rs.getInt("oid"));
                order.setIdProduct(pId);
                order.setNameProduct(product.getNameProduct());
                order.setImg(product.getImg());
                order.setPrice(product.getPrice()*rs.getInt("quantity"));
                order.setQuantity(rs.getInt("quantity"));
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;


    }

    public void cancelOrder(int id) {

        try {
            query = "delete from orders where oid=?";
            pst = this.connection.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
    

}

