package com.mylearnings.jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.Properties;

/**
 * Created by ronnie on 8/8/17.
 */
public class DBSelect {
    public static void main(String... args){
        Optional<Connection> connection=Optional.empty();
        try(
                FileInputStream fis = new FileInputStream("/Users/ronnie/IdeaProjects/Learnings/config.properties");
        ){
                Properties properties = new Properties();
                properties.load(fis);

                MysqlDataSource mysqlDataSource = new MysqlDataSource();
                mysqlDataSource.setUser(properties.getProperty("user"));
                mysqlDataSource.setPassword(properties.getProperty("password"));
                mysqlDataSource.setDatabaseName(properties.getProperty("db"));
                mysqlDataSource.setServerName("localhost");
                mysqlDataSource.setPortNumber(3306);
                connection=Optional.of(mysqlDataSource.getConnection());
                if(connection.isPresent()) {
                    try (
                            Connection mysql = connection.get();
                    ) {
                        PreparedStatement preparedStatement = mysql.prepareStatement("select * from employee where empname=?");
                        preparedStatement.setString(1, "Rekha");
                        ResultSet rs = preparedStatement.executeQuery();
                        while (rs.next()) {
                            System.out.println(rs.getString("empname"));
                        }
                    }
                }else{
                    System.out.println("Connection error");
                }
        }catch(Exception e){
            e.printStackTrace();
        }


    }


}
