//package dao;
//
//import model.Bill;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import static dao.CRUD_User.connection;
//
//public class BillDao {
//    public static void save(Bill bill) {
//        try {
//            String sql = "insert into bill (id_account,totalprice) value (?,?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, bill.getIdUser());
//            preparedStatement.setDouble(2, bill.getPriceBill());
//            preparedStatement.execute();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    public static int findIdMax() {
//        try {
//            String sql = "select max(id) as id\n" +
//                    "from bill";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            int idBill = -1;
//            while (resultSet.next()) {
//                idBill = resultSet.getInt("id");
//            }
//            return idBill;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return -1;
//    }
//}
