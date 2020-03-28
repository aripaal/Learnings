package com.mylearnings.jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

/**
 * Created by ronnie on 4/19/17.
 */
public class JDBCConnection {
    public static Optional<Connection> getConnection() throws SQLException{
        Optional<Connection> connection=Optional.empty();
        try (FileInputStream fileInputStream = new FileInputStream("/Users/ronnie/IdeaProjects/Learnings/config.properties")) {
            Properties properties = new Properties();
            properties.load(fileInputStream);

            MysqlDataSource mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setUser(properties.getProperty("user"));
            mysqlDataSource.setPassword(properties.getProperty("password"));
            mysqlDataSource.setDatabaseName(properties.getProperty("db"));
            mysqlDataSource.setServerName("localhost");
            mysqlDataSource.setPortNumber(3306);
            connection= connection.of(mysqlDataSource.getConnection());

        }catch (IOException e){
            e.printStackTrace();
        }
        return connection;
    }


}
