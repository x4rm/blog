package com.blog.util;

import com.blog.dao.MessageDAO;
import com.blog.dao.UserDAO;
import com.blog.dao.impl.MessageDAOIml;
import com.blog.dao.impl.UserDAOImpl;
import com.blog.model.Message;
import com.blog.model.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        /*
        * TODO: "Get user by login and password" method.
        * public static User getUser(String login, String password)
        * */

//        getUserByLoginPassword("rel", "123");

        /*
        * TODO: "Get users with equals fields values" method.
        * public static ArrayList<User> getUsers(User user)
        * */

        /*User user = new User();
        user.setGender(0);
        getUsersByCriteria(user);*/

        /*
        * TODO: "Add user message" method.
        * */

        /*User user = new User();
        user.setId(1);
        addMessage(user);*/

        /*
        * TODO: "Get user messages" method.
        * public static Set<Message> getUserMessages(User user)
        * */

        /*User user = new User();
        user.setId(1);
        getMessagesByUser(user);*/

        /*
        * ADD USER
        * TODO: Generate exception when fail.
        * */

        User user = new User();
        user.setLogin("e");
        addUser(user);

        /*
        * TODO: "Save user" method.
        * TODO: Rewrite user data method.
        * public static void saveUser(User user)
        * */

        /*User user = new User();
        user.setId(10);
        updateUser(user);*/

        /*
        * TODO: "Delete user" method.
        * public static void deleteUser(User user)
        * */

        /*User user = new User();
        user.setId(9);
        deleteUser(user);*/
    }

    public static void testDAO() {
       /* UserDAO */

//        User user = addUser();
//        updateUser(user);
//        User user = getUserById(1);
//        getAllUsers();
//        deleteUser(user);

        /* MessageDAO */

//        addMessage(user);
//        updateMessage(addMessage(user));
//        System.out.println(getMessageById(6).getText());
//        deleteMessage(getMessageById(9));
//        getMessagesByUser(user);
    }

    public static UserDAO userDAO = new UserDAOImpl();
    public static MessageDAO messageDAO = new MessageDAOIml();

    /* ADD MESSAGE */
    public static Message addMessage(User user) {
        try {
            Message message = new Message();
            message.setText("NANA");
            message.setUser(user);
            messageDAO.addMessage(message);
            return message;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* UPDATE MESSAGE */
    public static void updateMessage(Message message) {
        message.setText("2 FORM");
        try {
            messageDAO.updateMessage(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* GET MESSAGE BY ID */
    public static Message getMessageById(Integer message_id) {
        try {
            return messageDAO.getMessageById(message_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* DELETE MESSAGE */
    public static void deleteMessage(Message message) {
        try {
            messageDAO.deleteMessage(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* GET MESSAGE BY USER */
    public static void getMessagesByUser(User user) {
        try {
            ArrayList<Message> messages = (ArrayList<Message>) messageDAO.getMessagesByUser(user);
            for (Message message : messages) {
                System.out.println(message.getText());
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* ADD USER */
    public static User addUser(User user) {
        try {
            userDAO.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /* UPDATE USER */
    public static void updateUser(User user) {
        user.setLogin("tir");
        user.setPassword("222");
        user.setName("John Litz");
        user.setAge(22);
        user.setCity("Hir");
        user.setGender(0);

        try {
            userDAO.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* GET USER BY ID */
    public static User getUserById(int i) {
        try {
            User user = userDAO.getUserById(i);
            System.out.println(user.getName());
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* GET ALL USERS */
    public static void getAllUsers() {
        try {
            ArrayList<User> users = (ArrayList<User>) userDAO.getAllUsers();
            for (User user : users) {
                System.out.println(user.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* DELETE USER */
    public static void deleteUser(User user) {
        try {
            userDAO.deleteUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* GET USERS BY CRITERIA */
    public static void getUsersByCriteria(User user) {
        try {
            ArrayList<User> users = (ArrayList<User>) userDAO.getUsersByCriteria(user);
            for (User u : users) {
                System.out.println(u.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* GET USER BY LOGIN & PASSWORD*/
    public static void getUserByLoginPassword(String login, String password) {
        try {
            User user = userDAO.getUserByLoginPassword(login, password);
            System.out.println(user.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
