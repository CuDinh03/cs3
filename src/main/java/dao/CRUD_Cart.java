//package dao;
//
//import model.Cart;
//import model.ProductInCart;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CRUD_Cart {
//    static Connection connection = Connect_MySql.getConnect();
//    public static List<Cart> getAll(){
//        String sql = " Select * from Cart where status = 0 ";
//        List<Cart> Carts = new ArrayList<>();
//        try{
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()){
//                int idCart1 = resultSet.getInt("idCart");
//                int idUser = resultSet.getInt("idUser");
//                int price = resultSet.getInt("allPrice");
//                String product = resultSet.getNString("product1");
//                int status = resultSet.getInt("status");
//
//
//                Carts.add(new Cart(idCart1,idUser,price,product,0);
//            }
//        }catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
//        return Carts;
//    }
//
//    public static void save(Cart Cart){
//        try {
//            String sql = "insert into Cart(name,price,calo,quantity,img,status,detail) values (?,?,?,?,?,?,?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, Cart.getNameCart());
//            preparedStatement.setInt(2, Cart.getPrice());
//            preparedStatement.setInt(3, Cart.getCalo());
//            preparedStatement.setInt(4, Cart.getQuantity());
//            preparedStatement.setString(5, Cart.getImg());
//            preparedStatement.setBoolean(6, Cart.isStatus());
//            preparedStatement.setString(7, Cart.getDetail());
//        }catch (SQLException throwables){
//            throwables.printStackTrace();
//        }
//    }
//
//}
