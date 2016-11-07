package com.blog.dao.impl;

import com.blog.dao.UserDAO;
import com.blog.model.User;
import com.blog.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDAOImpl implements UserDAO{

    public void addUser(User user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateUser(User user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    /* TODO: May be useless */
    public User getUserById(Integer user_id) throws SQLException {
        Session session = null;
        User user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = (User) session.load(User.class, user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* TODO: org.hibernate.LazyInitializationException: could not initialize proxy - the owning Session was closed */
        /*finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }*/
        return user;
    }

    public User getUserByLoginPassword(String login, String password) throws SQLException {
        Session session = null;
        List users = new ArrayList<User>();
        User user = new User();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(User.class);
            criteria.setMaxResults(1);

            if (login != null && !"".equals(login)) {
                criteria.add(Restrictions.eq("login", login));
            }
            if (password != null && !"".equals(password)) {
                criteria.add(Restrictions.eq("password", password));
            }

            users = criteria.list();
            user = (User) users.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    public Collection getUsersByCriteria(User user) throws SQLException {
        Session session = null;
        List users = new ArrayList<User>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(User.class);

            if (user.getName() != null && !"".equals(user.getName())) {
                criteria.add(Restrictions.eq("name", user.getName()));
            }
            if (user.getAge() != null && user.getAge() > 0) {
                criteria.add(Restrictions.eq("age", user.getAge()));
            }
            if (user.getGender() != null) {
                criteria.add(Restrictions.eq("gender", user.getGender()));
            }
            if (user.getCity() != null && !"".equals(user.getCity())) {
                criteria.add(Restrictions.eq("city", user.getCity()));
            }

            users = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return users;
    }


    public Collection getAllUsers() throws SQLException {
        Session session = null;
        List users = new ArrayList<User>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            users = session.createCriteria(User.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return users;
    }

    public void deleteUser(User user) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
