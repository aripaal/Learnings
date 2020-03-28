package com.mylearnings.jdbc;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * Created by ronnie on 4/18/17.
 */
public class JDBCTest {
    public static Connection getConnection(String dbName,Properties properties) throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,properties);

    }

    public static Connection getDataSourceConnection(String dbNam,Properties properties) throws SQLException{
        MysqlDataSource dataSource= new MysqlDataSource();
        dataSource.setDatabaseName(dbNam);
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(3306);
        dataSource.setUser(properties.getProperty("user"));
        dataSource.setPassword(properties.getProperty("password"));
        return dataSource.getConnection();
        }


    public static void main(String... args){
        Properties connProps = new Properties();
        connProps.put("user","root");
        connProps.put("password","geniekcool");

        String sqlStmnt="select * from employee where empsalary>2000 ";
        String batch="insert into employee (empname,empsalary) values(?,?)";

        try (
                Connection connection = getDataSourceConnection("testDb",connProps);//getConnection("testDb",connProps);
                Statement statement=connection.createStatement();

        ){
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement= connection.prepareStatement(batch);
            preparedStatement.setString(1,"Amar");
            preparedStatement.setInt(2,2300);
            preparedStatement.addBatch();

            int[] count=preparedStatement.executeBatch();
            connection.commit();
            System.out.println(count.length+" rows executed");

            //            ResultSet rs= statement.executeQuery(sqlStmnt);
//            while(rs.next()){
//                int empid = rs.getInt("empid");
//                int empsalary = rs.getInt("empsalary");
//                String empname = rs.getString("empname");
//
//                System.out.println("empid="+empid+",empsalary="+empsalary+",empname="+empname);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }




}
