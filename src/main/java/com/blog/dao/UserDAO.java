package com.blog.dao;

import com.blog.model.User;

import java.sql.SQLException;
import java.util.Collection;

public interface UserDAO {

    public void addUser(User user) throws SQLException;
    public void updateUser(User user) throws SQLException;
    public User getUserById(Integer user_id) throws SQLException;
    public Collection getAllUsers() throws SQLException;
    public void deleteUser(User user) throws SQLException;

}
