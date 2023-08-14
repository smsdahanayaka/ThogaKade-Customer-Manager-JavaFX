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
    public Button btnBack;

    public void searchAction(ActionEvent actionEvent) throws Exception {
        search();
    }

    public void updateActionBtn(ActionEvent actionEvent) throws Exception {

        boolean bol;
        if(txtId.getId()!=""){
            double salary = Double.parseDouble(txtSalary.getText());
            Customer updatedCustomer = new Customer(txtId.getId(), txtName.getText(), txtAddress.getText(), salary);
            boolean success = Controller.updateCustomer(updatedCustomer);


            if(success){
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

    public void search() throws Exception {
        Customer customer= Controller.searchCustomer(txtId.getText());
        txtId.setText(customer.getId());
        txtName.setText(customer.getName());
        txtAddress.setText(customer.getAddress());
        txtSalary.setText(customer.getSalary()+"");

    }

    public void btnBackAction(ActionEvent actionEvent) {
        Controller.backMethod(actionEvent);
    }
}
