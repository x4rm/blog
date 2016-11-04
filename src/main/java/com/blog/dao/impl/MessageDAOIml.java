package com.blog.dao.impl;

import com.blog.dao.MessageDAO;
import com.blog.model.Message;
import com.blog.model.User;
import com.blog.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MessageDAOIml implements MessageDAO {

    public void addMessage(Message message) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(message);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateMessage(Message message) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(message);
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
    public Message getMessageById(Integer message_id) throws SQLException {
        Session session = null;
        Message message = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            message = (Message) session.load(Message.class, message_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* TODO: org.hibernate.LazyInitializationException: could not initialize proxy - the owning Session was closed */
        /*finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }*/
        return message;
    }

    public void deleteMessage(Message message) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(message);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Collection getMessagesByUser(User user) throws SQLException {
        Session session = null;
        List messages = new ArrayList<Message>();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Integer userId = user.getId();
            Query query = session.createQuery(
                    " select m "
                            + " from Message m INNER JOIN m.user user"
                            + " where user.id = :userId "
            ).setInteger("userId", userId);

            messages = (List<Message>) query.list();
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return messages;
    }

}
