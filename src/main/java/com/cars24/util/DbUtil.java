package com.cars24.util;

import com.cars24.config.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private static Connection connection;

    public static Connection getDbConnection(){
        try{
            if(connection == null)
                connection = DriverManager.getConnection(DbConfig.host, DbConfig.username, DbConfig.password);
            System.out.println("Connection successful");
            return connection;
        }
        catch(SQLException e){
            System.out.println("Connection failed successfully");
            throw new RuntimeException(e);
        }
    }

    public void closeConnection(){

    }
}
