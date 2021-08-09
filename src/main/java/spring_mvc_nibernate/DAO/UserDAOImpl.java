package spring_mvc_nibernate.DAO;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring_mvc_nibernate.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUsers() {


        return entityManager.createQuery("select  u from  User  u", User.class).getResultList();

    }

    @Override
    @Transactional
    public void saveUser(User user) {

        entityManager.merge(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {

        return  entityManager.find(User.class, id);

    }

    @Override
    @Transactional
    public void deleteUser(int id) {

     entityManager.createQuery("delete from User where id =:usId").setParameter("usId",id).executeUpdate();

    }
}
