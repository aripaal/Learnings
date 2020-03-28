package com.mylearnings.jdbc;

import sun.reflect.misc.ConstructorUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by ronnie on 4/19/17.
 */
public class EmployeeSearch {

    private String searchName="select * from employee where empname=?";
    private String searchSalary="select * from employee where empsalary >=?";


    public<T> void find(T value) throws SQLException{
        List<Employee> employeeList = new LinkedList<>();
        Optional<Connection> mysqlOptional = JDBCConnection.getConnection();
        if(mysqlOptional.isPresent()){
            try(
                    Connection connection=mysqlOptional.get();
                    PreparedStatement preparedStatement = createPreparedStatement(connection,value);
                    ResultSet rs=preparedStatement.executeQuery();
            ){
                while(rs.next()){
                    employeeList.add(new Employee(
                            rs.getString("empname"),
                            rs.getInt("empsalary")
                    ));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            employeeList.forEach(e->{
                System.out.println(e.getName()+","+e.getSalary());
            });

        }
    }
   private<T> PreparedStatement createPreparedStatement(Connection conn, T t) throws SQLException{
        if(t instanceof Integer){
            PreparedStatement p=conn.prepareStatement(searchSalary);
            p.setInt(1,(Integer)t);
            return p;
        }else if(t instanceof String){
            PreparedStatement p=conn.prepareStatement(searchName);
            p.setString(1,(String)t);
            return p;
        }
        return null;
    }

    public static void main(String... args) throws Exception{

        EmployeeSearch employeeSearch= new EmployeeSearch();
        try {
            employeeSearch.find("Arijit");
            System.out.println("--sal greater than 2000--");
            employeeSearch.find(3000);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
