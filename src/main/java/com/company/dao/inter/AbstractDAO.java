package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDAO {
    public Connection connect() throws Exception{
        //Class.forName("com.mysql.jdbc.Driver"); This is deprecated...
        String url = "jdbc:mysql://ip:port/db name";
        String username = "mysql username";
        String password = "mysql password";
        return DriverManager.getConnection(url, username, password);
    }
}
