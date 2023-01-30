package com.company.dao.impl;

import com.company.bean.User;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDAOInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl extends AbstractDAO implements UserDAOInter {

    @Override
    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();

        try(Connection c = connect()){
            Statement statement = c.createStatement();
            statement.execute("select * from user");
            ResultSet rs = statement.getResultSet();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                list.add(new User(id, name, surname, phone, email));
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public User getUserById(int id){
        User u = null;
        try(Connection c = connect()){
            Statement statement = c.createStatement();
            statement.execute("select * from user where id = " + id);
            ResultSet rs = statement.getResultSet();
            while (rs.next()){
                u = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("phone"),
                        rs.getString("email")
                );
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return u;
    }

    @Override
    public boolean addUser(User u) {
        try(Connection c = connect()){
            PreparedStatement ps = c.prepareStatement("insert into user(name, surname, phone, email) values(?, ?, ?, ?)");
            ps.setString(1, u.getName());
            ps.setString(2, u.getSurname());
            ps.setString(3, u.getPhone());
            ps.setString(4, u.getEmail());
            return ps.execute();
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(User u) {
        try(Connection c = connect()){
            PreparedStatement ps = c.prepareStatement("update user set name=?, surname=?, phone=?, email=? where id=?");
            ps.setString(1, u.getName());
            ps.setString(2, u.getSurname());
            ps.setString(3, u.getPhone());
            ps.setString(4, u.getEmail());
            ps.setInt(5, u.getId());
            return ps.execute();
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try(Connection c = connect()){
            PreparedStatement preparedStatement = c.prepareStatement("delete from user where id = ?");
            preparedStatement.setInt(1, id);
            return preparedStatement.execute();
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
