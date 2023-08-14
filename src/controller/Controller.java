package controller;

import connections.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Customer;

import java.io.IOException;
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
        int x=stm.executeUpdate("UPDATE customer SET name = '"+customer.getName()+"', address = '"+customer.getAddress()+"', salary = "+customer.getSalary()+" WHERE id = 'C004'");
        return x>0;
    }

    public static ObservableList<Customer> viewCustomers() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        Statement statement=connection.createStatement();
        ResultSet rst = statement.executeQuery("SELECT *FROM customer");

        ObservableList<Customer> list= FXCollections.observableArrayList();

                while(rst.next()){

                    list.add( new Customer(rst.getString("id"),rst.getString("name"),rst.getString("address"),rst.getDouble("salary")));
                }



                return list;
    }

    public static void backMethod(ActionEvent event){

        Parent root;
        try {
            root = FXMLLoader.load(Controller.class.getClassLoader().getResource("view/MainViewForm.fxml"));
            Stage stage = new Stage();
            stage.setTitle("All Customers");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
