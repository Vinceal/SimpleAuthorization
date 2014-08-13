package com.example.app.controller;

import com.example.app.controller.impl.UserDaoImpl;
import com.example.app.model.DAO.IUserDao;

/**
 * Singleton
 * Factory with DaoImpl
 *
 * @author Vinceal
 * @version 0.0.1
 * */
public class Factory {

    private static Factory instance;
    public static Factory getInstance(){

        if (instance == null){
            synchronized (Factory.class){
                if (instance == null){
                    instance = new Factory();
                }
            }
        }
        return instance;
    }


    private IUserDao iUserDao;
    /**
     * @return object user dao implementation
     * */
    public IUserDao getiUserDao(){
        if (iUserDao==null){
            iUserDao = new UserDaoImpl();
        }
       return iUserDao;
    }
}
