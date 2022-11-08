package dao;

import model.Cart;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD_Product {

    static Connection connection = Connect_MySql.getConnect();

    private Connection connection1;

    public CRUD_Product() {

    }

    public CRUD_Product(Connection connection1) {
        super();
        this.connection1 = connection1;
    }

    public static List<Product> getAll() {
        String sql = " Select * from product where status = 0";
        List<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int idProduct1 = resultSet.getInt("idProduct");
                String name = resultSet.getString("nameProduct");
                int price = resultSet.getInt("price");
                int calo = resultSet.getInt("calo");
                int quantity = resultSet.getInt("quantity");
                String img = resultSet.getString("img");
                int status = resultSet.getInt("status");
                String detail = resultSet.getString("detail");

                products.add(new Product(idProduct1, name, price, calo, quantity, img, status, detail));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    public static void save(Product product) {
        try {
            String sql = "insert into product(nameproduct,price,calo,quantity,img,status,detail) values (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getCalo());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setString(5, product.getImg());
            preparedStatement.setInt(6, product.getStatus());
            preparedStatement.setString(7, product.getDetail());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void delete(int id) {
        try {

            String sql = "UPDATE product SET status = 1 WHERE idproduct = ? ";
            Connection connection1 = Connect_MySql.getConnect();
            PreparedStatement preparedStatement = connection1.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public Product getSingleProduct(int id) {
        Product row = null;
        try {
            String query = "select * from product where idproduct=? ";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                row = new Product();
                row.setIdProduct(rs.getInt("idProduct"));
                row.setNameProduct(rs.getString("nameProduct"));
                row.setPrice(rs.getInt("price"));
                row.setCalo(rs.getInt("calo"));
                row.setQuantity(rs.getInt("quantity"));
                row.setImg(rs.getString("img"));
                row.setStatus(rs.getInt("status"));
                row.setDetail(rs.getString("detail"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return row;
    }

    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> book = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                   String query = "select * from product where idproduct=?";
                    PreparedStatement pst = this.connection1.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getInt("idProduct"));
                        row.setNameProduct(rs.getString("nameProduct"));
                        row.setImg(rs.getString("img"));
                        row.setPrice((int) (rs.getDouble("price")*item.getQuantity()));
                        row.setQuantity(item.getQuantity());
                        book.add(row);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return book;
    }


    public double getTotalCartPrice(ArrayList<Cart> cartList) {
        double sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    String query = "select price from product where idproduct=?";
                    PreparedStatement pst = this.connection1.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        sum+=rs.getDouble("price")*item.getQuantity();
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }

    public static void edit(int id, String name, int price, int calo  , int quantity, String img, int status, String detail) {
        try {

            String sql = "UPDATE product SET nameProduct = ? , price = ? , calo = ?, quantity = ? , img = ?, status = ? , detail = ? WHERE idProduct = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,price);
            preparedStatement.setInt(3,calo);
            preparedStatement.setInt(4,quantity);
            preparedStatement.setString(5,img);
            preparedStatement.setInt(6,status);
            preparedStatement.setString(7,detail);
            preparedStatement.setInt(8,id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


}
