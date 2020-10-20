package ua.mate.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ua.mate.dao.UserDao;
import ua.mate.exception.DataProcessionException;
import ua.mate.model.User;

@Repository
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession().getSession();
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new DataProcessionException("Can't add user " + user, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<User> listUsers() {
        try (Session session = sessionFactory.openSession().getSession()) {
            Query<User> getUsersQuery = session.createQuery("from User", User.class);
            return getUsersQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessionException("Can't get users", e);
        }
    }

    @Override
    public User getById(Long id) {
        try (Session session = sessionFactory.openSession().getSession()) {
            Query<User> getUserByIdQuery = session.createQuery("from User u "
                    + "where u.id = :id", User.class);
            getUserByIdQuery.setParameter("id", id);
            return getUserByIdQuery.getSingleResult();
        } catch (Exception e) {
            throw new DataProcessionException("Can't get user by id " + id, e);
        }
    }
}
