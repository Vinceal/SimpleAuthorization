package com.example.app.view;

import com.example.app.controller.Factory;
import com.example.app.model.DAO.IUserDao;
import com.example.app.model.User;

import java.util.List;
import java.util.Scanner;

/**
 * Entry point of program.
 * Read user login and password from console
 * and check with login and password in DataBase
 *
 * @author Vinceal
 * @version 0.0.1
 * */
public class EntryPoint {
    public static void main (String[] args){

        Factory factory = Factory.getInstance();

        IUserDao userDao = factory.getiUserDao();

        List<User> userList = userDao.getAllUser();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter login ");
        String login = sc.nextLine();
        login.trim();
        System.out.println("");

        System.out.println("Enter pass ");
        String pass = sc.nextLine();
        pass.trim();

        boolean authorized = false;

        if (login != null && pass != null){

            for (User user: userList){
                if (user.getLogin().equalsIgnoreCase(login)
                        && user.getPassword().equalsIgnoreCase(pass)){

                    System.out.println("Authorization success!");
                    authorized = true;
                }

            }

            if (!authorized){

                System.out.println("Authorization fall =(");
            }
        }
    }
}
