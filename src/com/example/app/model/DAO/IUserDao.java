package com.example.app.model.DAO;

import com.example.app.model.User;

import java.util.List;

/**
 * @author Vinceal
 * @version 0.0.1
 * */
public interface IUserDao {

    public void addUser (User user);
    public void deleteUser(User user);
    public User getUser(int id);
    public List<User> getAllUser();
}
