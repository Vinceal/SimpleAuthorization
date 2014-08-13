package com.example.app.controller.impl;

import com.example.app.controller.utils.Hibernate;
import com.example.app.model.DAO.IUserDao;
import com.example.app.model.User;
import org.hibernate.Session;

import java.util.List;

/**
 * @author Vinceal
 * @version 0.0.1
 * */
public class UserDaoImpl implements IUserDao {


    /**
     * @param user Пользователь
     * */
    @Override
    public void addUser(User user){
        Session session = null;
        try {
            session = Hibernate.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session!=null && session.isOpen()){
                session.close();
            }
        }
    }

    /**
     * @param user user
     * */
    @Override
    public void deleteUser(User user) {
        Session session = null;
        try {
            session = Hibernate.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session!=null && session.isOpen()){
                session.close();
            }
        }
    }

    /**
     * @param id user id from DataBase
     * @return user
     * */
    @Override
    public User getUser(int id) {
        User user = null;
        Session session = null;
        try {
            session = Hibernate.getSessionFactory().openSession();
            user = (User) session.get(User.class, id);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session!=null && session.isOpen()){
                session.close();
            }
        }
        return user;
    }


    /**
     * @return list all users
     * */
    @Override
    public List<User> getAllUser(){
        List<User> userList = null;
        Session session = null;
        try {
            session = Hibernate.getSessionFactory().openSession();
            userList = session.createCriteria(User.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (session!=null && session.isOpen()){
                session.close();
            }
        }
        return userList;
    }
}
