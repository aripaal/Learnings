package com.mylearnings.jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

/**
 * Created by ronnie on 4/19/17.
 */
public class DbRead {
    private String query="select * from employee where empname=?";
    public static Optional<Connection> getConnection(){
        Optional<Connection> connectionOptional= Optional.empty();
        try(
                FileInputStream fis = new FileInputStream("/Users/ronnie/IdeaProjects/Learnings/config.properties")
        ){
            Properties sqlProp = new Properties();
            sqlProp.load(fis);
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb",sqlProp);
//            MysqlDataSource mysqlDataSource = new MysqlDataSource();
//            mysqlDataSource.setDatabaseName(sqlProp.getProperty("db"));
//            mysqlDataSource.setServerName("localhost");
//            mysqlDataSource.setPort(3306);
//            mysqlDataSource.setUser(sqlProp.getProperty("user"));
//            mysqlDataSource.setPassword(sqlProp.getProperty("password"));
            connectionOptional= Optional.of(connection);

        }catch(Exception e){
                    e.printStackTrace();
        }
        return connectionOptional;
    }

    public void runQuery(String name) throws SQLException{
        List<Employee> employeeList = new LinkedList<>();
        Optional<Connection> connection = getConnection();
        if(connection.isPresent()){
            try(
                    Connection conn=connection.get();
                    PreparedStatement p = getStatement(conn,name);
                    ResultSet r = p.executeQuery();
            ){

                while(r.next()){
                    employeeList.add(new Employee(
                            r.getString("empname"),
                            r.getInt("empsalary")
                    ));
                }

                employeeList.forEach(e-> System.out.println(e.getName()+","+e.getSalary()));

            }
        }
        else{
            System.out.println("No connection was made");
        }
    }

    private PreparedStatement getStatement(Connection conn,String name) throws SQLException{
        PreparedStatement statement=conn.prepareStatement(query);
        statement.setString(1,name);
        return statement;
    }



    public static void main(String... args){

        DbRead read = new DbRead();
        try {
            read.runQuery("Rekha");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
