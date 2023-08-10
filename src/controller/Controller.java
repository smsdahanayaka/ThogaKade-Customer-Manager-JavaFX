package controller;

import connections.DBConnection;
import model.Customer;

import java.sql.Connection;
import java.sql.Statement;

public class Controller {
    public Controller(){

    }

    public static boolean addCustomer(Customer customer) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        Statement stm=connection.createStatement();
        return 0<stm.executeUpdate("INSERT INTO customer VALUES ('"+customer.getId()+"','"+customer.getName()+"','"+customer.getAddress()+"','"+customer.getSalary()+"')");

    }
}
