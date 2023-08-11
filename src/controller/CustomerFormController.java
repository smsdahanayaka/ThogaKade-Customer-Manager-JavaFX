package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Customer;

public class CustomerFormController {
    public Button btnAdd;
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;

    public void addActionBtn(ActionEvent actionEvent) throws Exception {
       boolean isDone= Controller.addCustomer(new Customer(txtId.getText(),txtName.getText(),txtAddress.getText(),Double.parseDouble(txtSalary.getText())));
       if(true){
           txtId=null;
           txtName=null;
           txtAddress=null;
           txtSalary=null;

       }

    }
}
