package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

public class ViewCustomersController {

    public Button btnBack;
    @FXML
    private TableColumn<Customer, String> addCol;

    @FXML
    private Button btnRef;

    @FXML
    private TableColumn<Customer, String> idCol;

    @FXML
    private TableColumn<Customer, String> nameCol;

    @FXML
    private TableColumn<Customer, Double> salCol;

    @FXML
    private TableView<Customer> tblCost;


    @FXML
    void refAction(ActionEvent event) throws Exception {
        ObservableList<Customer> list= Controller.viewCustomers();
        idCol.setCellValueFactory(new PropertyValueFactory<Customer,String>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Customer,String>("name"));
        addCol.setCellValueFactory(new PropertyValueFactory<Customer,String>("address"));
        salCol.setCellValueFactory(new PropertyValueFactory<Customer,Double>("salary"));

        tblCost.setItems(list);
    }

    public void btnBackAction(ActionEvent actionEvent) {
        Controller.backMethod(actionEvent);
    }
}
