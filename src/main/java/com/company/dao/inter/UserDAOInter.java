package com.company.dao.inter;

import com.company.bean.User;

import java.util.List;

public interface UserDAOInter {
    List<User> getAllUser();
    User getUserById(int id);
    boolean addUser(User u);
    boolean updateUser(User u);
    boolean removeUser(int id);
}
