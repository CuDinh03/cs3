package dao;

import model.User;

import java.sql.*;
public class LoginDao {
    public static User login(String username, String password) {
        try {
            String sql = "Select * from user where username = ? and password = ?";
            Connection connection = Connect_MySql.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;

            if (resultSet.next()) {
                int iduser1 = resultSet.getInt("idUser");
                String nameuser1 = resultSet.getString("nameUser");
                String username1 = resultSet.getString("userName");
                String password1 = resultSet.getString("passWord");
                String contact1 = resultSet.getString("contact");
                String address1 = resultSet.getString("address");
                String email1 = resultSet.getString("email");
                String img1 = resultSet.getString("img");
                int role1 = resultSet.getInt("role");

                user = new User(iduser1,nameuser1, username1, password1,contact1, address1,email1,img1,role1);
            }
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

}
