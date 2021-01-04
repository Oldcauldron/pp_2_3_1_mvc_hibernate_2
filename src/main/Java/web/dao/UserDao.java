package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();
    User show(int id);
    void addUser(User user);
    void addUser(String name, int age);
    void removeUser(int id);
    void updateUser(int id, String name, int age);
    void deleteAll();
}
