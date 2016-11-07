package com.blog.util;

import com.blog.dao.MessageDAO;
import com.blog.dao.UserDAO;
import com.blog.dao.impl.MessageDAOIml;
import com.blog.dao.impl.UserDAOImpl;
import com.blog.model.Message;
import com.blog.model.User;

import java.sql.SQLException;
import java.util.*;

public class DBUtil {

    public static UserDAO userDAO = new UserDAOImpl();
    public static MessageDAO messageDAO = new MessageDAOIml();


    /*
    * GET USER
    * TODO: "Get user by login and password" method.
    * TODO: Generate exception when fail.
    * */
    public static User getUser(String login, String password) throws Exception {
        try {
            User user = userDAO.getUserByLoginPassword(login, password);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    * UPDATE USER
    * TODO: "update user" method.
    * TODO: Rewrite user data method.
    * TODO: Generate exception when fail.
    * */
    public static void saveUser(User user) throws Exception {
        try {
            userDAO.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    * ADD USER
    * TODO: Generate exception when fail.
    * */
    public static void addUser(User user) throws Exception {
        try {
            userDAO.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    * GET USER MESSAGES
    * TODO: "Get user messages" method.
    * TODO: Convert db date type to calendar type;
    * */
//    public static ArrayList<Message> getUserMessages(User user) {
//    ArrayList<Message> messages = new ArrayList<Message>();

//    public static Set<Message> getUserMessages(User user) {
    public static ArrayList<Message> getUserMessages(User user) {
        try {
//            return (Set<Message>) messageDAO.getMessagesByUser(user);
            return (ArrayList<Message>) messageDAO.getMessagesByUser(user);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    * DELETE USER
    * TODO: "Delete user" method.
    * */
    public static void deleteUser(User user) throws Exception {
        try {
            userDAO.deleteUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    * GET ALL USERS
    * TODO: "Get users with equals fields values" method.
    * */
    public static ArrayList<User> getAllUsers() throws Exception {
        try {
            return  (ArrayList<User>) userDAO.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /*
    * GET USERS BY CRITERIA
    * TODO: "Get users with equals fields values" method.
    * */
    public static ArrayList<User> getUsersByCriteria(User user) throws Exception {
        try {
            return  (ArrayList<User>) userDAO.getUsersByCriteria(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* ADD MESSAGE
    * TODO: Message with user.
    * */
    public static Message addMessage(User user, Message message) {
        try {
            message.setUser(user);
            messageDAO.addMessage(message);
            return message;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
