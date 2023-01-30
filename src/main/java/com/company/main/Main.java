package com.company.main;

import com.company.bean.User;
import com.company.dao.inter.UserDAOInter;

import java.util.List;

public class Main {
    public static void main(String[] args){

//        UserDAOInter userDAO = new UserDAOImpl(); //tightly coupled
        UserDAOInter userDAO = Context.instanceUserDAO(); //loosely coupled

        List<User> result = userDAO.getAllUser();
        System.out.println(result);

        User uRovshan = userDAO.getUserById(1);
        System.out.println(uRovshan);

        uRovshan.setSurname("My new surname");
        userDAO.updateUser(uRovshan);

        userDAO.removeUser(10);

        userDAO.addUser(new User(0, "Rovshan", "m", "+9999999", "rov@gmail.com"));
        result = userDAO.getAllUser();
        System.out.println(result);
    }
}