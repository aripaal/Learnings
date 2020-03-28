package com.mylearnings.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by ronnie on 4/19/17.
 */
public class DBBatch {

    private String batchInsert = "insert into employee (empname,empsalary) values(?,?)";

    public void batchUpdate(List<Employee> list) throws SQLException{
        Optional<Connection> mysqlConnection = JDBCConnection.getConnection();
        if(mysqlConnection.isPresent()){
            try(
                    Connection connection=mysqlConnection.get();
                    PreparedStatement preparedStatement=connection.prepareStatement(batchInsert);
            ){
                connection.setAutoCommit(false);

                for(Employee e: list){
                    preparedStatement.setString(1,e.getName());
                    preparedStatement.setInt(2,e.getSalary());
                    preparedStatement.addBatch();

                }
                int[] rowUpdate = preparedStatement.executeBatch();
                System.out.println(" Rows commited ->"+rowUpdate.length);
                connection.commit();
            }
        }
    }


    public static void main(String... args){

        List<Employee> employeeList = new LinkedList<>();
        employeeList.add(new Employee("Amma",3100));
        employeeList.add(new Employee("moni",300));

        DBBatch batch = new DBBatch();
        try{
            batch.batchUpdate(employeeList);

        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
