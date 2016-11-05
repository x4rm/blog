package com.blog.util;

import com.blog.model.Message;
import com.blog.model.User;

import java.util.ArrayList;
import java.util.Date;

public class MockupDBUtil {

    /*
    * GET USER
    * TODO: "Get user by login and password" method.
    * TODO: Generate exception when fail.
    * */
    public static User getUser(String login, String password) throws Exception {
        if ("litz".equals(login) && "123".equals(password)) {
            User user = new User();
            user.setLogin("litz");
            user.setPassword("123");
            user.setName("Ann Litz");
            user.setAge(21);
            user.setCity("Monaco");
            user.setGender(1);
            return user;
        } else {
            throw new Exception("No user with such login and password.");
        }
    }

    /*
    * SAVE USER
    * TODO: "Save user" method.
    * TODO: Generate exception when fail.
    * */
    public static void saveUser(User user) throws Exception {
        if ("litz".equals(user.getLogin())) {
            throw new Exception("Login must be unique.");
        }
    }

    public static ArrayList<Message> getUserMessages(User user) {
        /* TODO: Get user's messages */
        ArrayList<Message> messages = new ArrayList<Message>();
        Message message1 = new Message();
        message1.setText("Nanana.");

        /* TODO: Save and output dates */
        message1.setDate(new Date(2014, 10, 2));
        message1.setTime(new Date(2014, 10, 2));

        Message message2 = new Message();
        message2.setText("Tratata.");
        message2.setDate(new Date(2014, 10, 2));
        message2.setTime(new Date(2014, 10, 2));

        messages.add(message1);
        messages.add(message2);
        return messages;
    }

    public static void deleteUser(User user) {
        /* TODO: Delete user */
    }

    public static ArrayList<User> getUsers(User user) {
        /* TODO: Generate exception if no users with entered attributes */
        ArrayList<User> users = new ArrayList<User>();
        if (user != null) {
            User user1 = new User();
            user1.setName("Ann Litz");
            user1.setAge(21);
            user1.setCity("Monaco");
            user1.setGender(1);

            User user2 = new User();
            user2.setName("Kate Winst");
            user2.setAge(26);
            user2.setCity("Lion");
            user2.setGender(1);

            User user3 = new User();
            user3.setName("Lil Rout");
            user3.setAge(32);
            user3.setCity("Panama");
            user3.setGender(1);

            users.add(user1);
            users.add(user2);
            users.add(user3);
        }
        return users;
    }


}
