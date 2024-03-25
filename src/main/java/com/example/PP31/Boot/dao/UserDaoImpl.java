package com.example.PP31.Boot.dao;
import com.example.PP31.Boot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user ", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(long userId) {
        User user = entityManager.find(User.class, userId);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(long id, User userUpdate) {
        User user = getUser(id);
        user.setName(userUpdate.getName());
        user.setEmail(userUpdate.getEmail());
        entityManager.merge(user);
    }


    @Override
    public User getUser(long userId) {
        return entityManager.find(User.class, userId);
    }
}
