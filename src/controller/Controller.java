package controller;

import connections.DBConnection;
import model.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller {
    private static Customer customer;
    public Controller(){

    }

    public static boolean addCustomer(Customer customer) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        Statement stm=connection.createStatement();
        return 0<stm.executeUpdate("INSERT INTO customer VALUES ('"+customer.getId()+"','"+customer.getName()+"','"+customer.getAddress()+"','"+customer.getSalary()+"')");

    }

    public static Customer searchCustomer(String id) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst =stm.executeQuery("SELECT *FROM customer WHERE id='"+id+"'");

        while(rst.next()){
            customer= new Customer(id,rst.getString("name"),rst.getString("address"), rst.getDouble("salary"));
        }
        return customer;
    }

    public static boolean deleteCustomer(String id) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        Statement stm=connection.createStatement();
        return 0 < stm.executeUpdate("DELETE FROM customer WHERE id='"+id+"'");
    }

    public static boolean updateCustomer(Customer customer) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        Statement stm=connection.createStatement();

        return  0 < stm.executeUpdate("UPDATE customer SET name='"+customer.getName()+"', address='"+customer.getAddress()+"',salary='"+customer.getSalary()+"' WHERE id='"+customer.getId()+"'");

    }
}
