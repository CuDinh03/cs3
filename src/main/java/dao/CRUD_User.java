package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD_User {
    static Connection connection = Connect_MySql.getConnect();

    public static List<User> getAll() {
        String sql = "Select * from user where status = 0";
        List<User> users = new ArrayList<>();
        try {
            // tạo cái xe để đưa câu lệnh sql qua CSDL
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("iduser");
                String name = resultSet.getString("nameUser");

                String username = resultSet.getString("userName");
                String password = resultSet.getString("passWord");
                String contact = resultSet.getString("contact");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String img = resultSet.getString("img");
                int role = resultSet.getInt("role");
                users.add(new User(id, name, username, password,contact, address, email,img,role, 0));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    public static void save(User user) {
        try {
            String sql = "insert into user (nameUser,userName,passWord ,contact,address,email,img,role) values (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getNameUser());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassWord());
            preparedStatement.setString(4, user.getContact());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getImg());
            preparedStatement.setInt(8,user.getRole());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void edit(int id, String name,String email, String phone , String img, String address) {
        try {

            String sql = "UPDATE user SET nameuser = ? , contact = ? , address = ?, email = ? , img = ? WHERE idUser = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,phone);
            preparedStatement.setString(3,address);
            preparedStatement.setString(4,email);
            preparedStatement.setString(5,img);
            preparedStatement.setInt(6,id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public User getUserByIdD(int id){
        String sql = "select * from user where iduser = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return new User(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInt(9));
            }
        }catch (Exception e){

        }
        return null;
    }
    public static void delete(int id) {
        try {

            String sql = "UPDATE user SET status = 1 WHERE iduser = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

}
