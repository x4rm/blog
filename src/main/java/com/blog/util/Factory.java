package com.blog.util;

import com.blog.dao.MessageDAO;
import com.blog.dao.UserDAO;
import com.blog.dao.impl.MessageDAOIml;
import com.blog.dao.impl.UserDAOImpl;

public class Factory {

    private static UserDAO userDAO = null;
    private static MessageDAO messageDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public UserDAO getUserDAO(){
        if (userDAO == null){
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }

    public MessageDAO getMessageDAO(){
        if (messageDAO == null){
            messageDAO = new MessageDAOIml();
        }
        return messageDAO;
    }

}
