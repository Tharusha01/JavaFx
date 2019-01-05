package javaFx;

import connectivity.connectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userController {

    @FXML
    Label lbPError;

    @FXML
    private TableView<CustomerDetails> tableCustomer;

    @FXML
    private TableColumn<CustomerDetails, String> tbCusName;

    @FXML
    private TableColumn<CustomerDetails, String> tbCusEmail;

    @FXML
    private TableColumn<CustomerDetails, String> tbCusAddress;

    private ObservableList<CustomerDetails> data;

    @FXML
    void btnLoadStaffDetails(MouseEvent mouseEvent) {

        connectivity.connectionClass connectionClass = new connectionClass();
        Connection connection = connectionClass.getConnection();
        data= FXCollections.observableArrayList();

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSetUpdate = statement.executeQuery("select * from user_registration");
            while (resultSetUpdate.next()) {
                //get string from db,whichever way
                data.add(new CustomerDetails(resultSetUpdate.getString(1), resultSetUpdate.getString(2), resultSetUpdate.getString(3)));
            }

        } catch (SQLException e) {
            lbPError.setText("Error");
        }

        tbCusName.setCellValueFactory(new PropertyValueFactory<>("cuName"));
        tbCusEmail.setCellValueFactory(new PropertyValueFactory<>("cuEmail"));
        tbCusAddress.setCellValueFactory(new PropertyValueFactory<>("cuAddress"));

        tableCustomer.setItems(null);
        tableCustomer.setItems(data);

    }


    @FXML
    void btnBackToHome(MouseEvent mouseEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));

            Node node = (Node) mouseEvent.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
