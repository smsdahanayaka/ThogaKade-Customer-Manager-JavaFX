package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnView;

    @FXML
    void btnAddAction(ActionEvent event) {
        // Handle the button action here

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/CustomerForm.fxml"));
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

    @FXML
    void btnDeleteAction(ActionEvent event) {
        // Handle the button action here
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/DeleteCustomer.fxml"));
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

    @FXML
    void btnExitAction(ActionEvent event) {
        // Handle the button action here
        System.exit(0);
    }

    @FXML
    void btnSearchAction(ActionEvent event) {
        // Handle the button action here

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/SearchCustomerForm.fxml"));
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

    @FXML
    void btnUpdateAction(ActionEvent event) {
        // Handle the button action here

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/UpdateCustomerForm.fxml"));
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

    @FXML
    void btnViewAction(ActionEvent event) {

            Parent root;
            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("view/ViewCustomersForm.fxml"));
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
