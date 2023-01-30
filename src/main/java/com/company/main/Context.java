package com.company.main;

import com.company.dao.impl.UserDAOImpl;
import com.company.dao.inter.UserDAOInter;

public class Context {
    public static UserDAOInter instanceUserDAO() { //loosely coupled
        return new UserDAOImpl();
    }
}
