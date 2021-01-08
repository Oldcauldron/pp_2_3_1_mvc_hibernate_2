package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    public User show(int id) {
        return userDao.show(id);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void addUser(String name, int age) {
        userDao.addUser(name, age);
    }

    @Override
    public void removeUser(int id) {
        userDao.removeUser(id);
    }

    @Override
    public void updateUser(int id, String name, int age) {
        userDao.updateUser(id, name, age);
    }

    @Override
    public void deleteAll() {
        userDao.deleteAll();
    }
}
