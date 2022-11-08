package service;

import dao.CRUD_User;
import model.User;

import java.util.List;

public class UserService implements IService<User>{

    static List<User> users = CRUD_User.getAll();


    @Override
    public List<User> showAll() {
        return users;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public boolean deleteById(int id, User user) {
        return false;
    }

    @Override
    public boolean editById(int id, User user) {
        return false;
    }


    public User findUserByNameUser(String name, String pass){
        for (User user : users) {
            if (user.getUserName().equals(name) && user.getPassWord().equals(pass)){
                return user;
            }
        }
        return null;
    }
    public static void create(User user) {
        users.add(user);
        CRUD_User.save(user);
    }
}
