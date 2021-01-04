package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        String query = "select u from User u";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        return typedQuery.getResultList();
    }

    @Override
    public User show(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void addUser(String name, int age) {
        User user = new User(name, age);
        addUser(user);
    }

    @Override
    public void removeUser(int id) {
        User user = show(id);
        if (user != null) entityManager.remove(user);
    }

    @Override
    public void updateUser(int id, String name, int age) {
        User user = show(id);
        user.setName(name);
        user.setAge(age);
        entityManager.merge(user);
    }

    @Override
    public void deleteAll() {
//        String query = "drop table if exists users";
        String query = "drop table if exists users";
        String query2 = "create table if not exists users(" +
                        "id int auto_increment primary key," +
                        "name text null," +
                        "age int null" +
                        ")";
        entityManager.createNativeQuery(query).executeUpdate();
        entityManager.createNativeQuery(query2).executeUpdate();
    }
}
