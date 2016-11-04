package com.blog.dao;

import com.blog.model.Message;
import com.blog.model.User;

import java.sql.SQLException;
import java.util.Collection;

public interface MessageDAO {

    public void addMessage(Message message) throws SQLException;
    public void updateMessage(Message message) throws SQLException;
    public Message getMessageById(Integer message_id) throws SQLException;
    public void deleteMessage(Message message) throws SQLException;
    public Collection getMessagesByUser(User user) throws SQLException;

}
