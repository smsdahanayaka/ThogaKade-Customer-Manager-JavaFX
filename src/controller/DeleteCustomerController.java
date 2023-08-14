package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Customer;

public class DeleteCustomerController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;
    public Button btnDelete;
    public Button btnBack;

    public void searchCustomerAction(ActionEvent actionEvent) throws Exception {
        String id=search();
    }

    public void deletAction(ActionEvent actionEvent) throws Exception {
       String id=search();
       boolean bl= Controller.deleteCustomer(id);
       if(bl){
           System.out.println("done");
           txtId.setText("");
           txtName.setText("");
           txtAddress.setText("");
           txtSalary.setText("");
           Alert alert=new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("DELETE");
           alert.setHeaderText("Delete Successfull");
           alert.show();
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

    public void btnBackAction(ActionEvent actionEvent) {
        Controller.backMethod(actionEvent);
    }
}
