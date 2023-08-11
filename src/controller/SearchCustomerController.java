package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Customer;

public class SearchCustomerController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;
    public Button btnSearch;

    public void idSearch(ActionEvent actionEvent) throws Exception {
        search();
    }

    public void searchActionBtn(ActionEvent actionEvent) throws Exception {
        search();
    }
    public void search() throws Exception {
       Customer customer= Controller.searchCustomer(txtId.getText());
       txtId.setText(customer.getId());
       txtName.setText(customer.getName());
       txtAddress.setText(customer.getAddress());
       txtSalary.setText(customer.getSalary()+"");
    }
}
