package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Customer;

public class UpdateCustomerController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;
    public Button btnUpdate;

    public void searchAction(ActionEvent actionEvent) throws Exception {
        search();
    }

    public void updateActionBtn(ActionEvent actionEvent) throws Exception {
        String id= search();
        boolean bol;
        if(id!=""){
           bol= Controller.updateCustomer(new Customer(id,txtName.getText(),txtAddress.getText(),Double.parseDouble(txtSalary.getText())));
           if(bol){
               Alert alert=new Alert(Alert.AlertType.INFORMATION);
               alert.setHeaderText("Done");
               alert.show();
               txtId.setText("");
               txtName.setText("");
               txtAddress.setText("");
               txtSalary.setText("");
           }
        }
    }

    public String search() throws Exception {
        Customer customer= Controller.searchCustomer(txtId.getText());
        txtId.setText(customer.getId());
        txtName.setText(customer.getName());
        txtAddress.setText(customer.getAddress());
        txtSalary.setText(customer.getSalary()+"");
        return customer.getId();
    }
}
